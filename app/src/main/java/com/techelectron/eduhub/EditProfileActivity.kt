package com.techelectron.eduhub

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.iceteck.silicompressorr.FileUtils
import com.iceteck.silicompressorr.SiliCompressor
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.activity_edit_profile.*
import java.io.File


class EditProfileActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var query: Query
    lateinit var userEmail: String
    lateinit var userUid: String
    lateinit var imageUri: Uri
    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Users")

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("EduHub")
        progressDialog.setMessage("Updating info")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        checkUserStatus()

        imageUri = Uri.parse("")

        query = databaseReference.orderByChild("email").equalTo(userEmail)

        getUserData(query)

        backBtn.setOnClickListener {
            onBackPressed()
        }

        editProfileIv.setOnClickListener {
            picImage()
        }

        doneBtn.setOnClickListener {
            val name = nameEt.text.toString().trim()
            val position = positionEt.text.toString().trim()
            val mobileNo = mobileNoEt.text.toString().trim()
            val about = aboutMeEt.text.toString().trim()
            val skills = skillsEt.text.toString().trim()
            val city = cityEt.text.toString().trim()

            progressDialog.show()

            changeData(name, position, mobileNo, about, skills, city)
            changeProfilePic()
        }


    }

    private fun changeData(name: String, position: String, mobileNo: String, about: String, skills: String, city: String){
        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(position) || !TextUtils.isEmpty(mobileNo)
                || !TextUtils.isEmpty(about) || !TextUtils.isEmpty(skills) || !TextUtils.isEmpty(city)){

            val hashMap = HashMap<String, Any>()
            hashMap["name"] = name
            hashMap["position"] = position
            hashMap["mobileNo"] = mobileNo
            hashMap["about"] = about
            hashMap["skills"] = skills
            hashMap["city"] = city

            val ref = FirebaseDatabase.getInstance().getReference("Posts")
            val query: Query = ref.orderByChild("uid").equalTo(userUid)

            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val child = ds.key
                        if (child != null) {
                            dataSnapshot.ref.child(child).child("uName").setValue(name)
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })

            databaseReference.child(userUid).updateChildren(hashMap)
                    .addOnSuccessListener {
                    }.addOnFailureListener {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                    }
        }
    }

    private fun getUserData(query: Query){
        query.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children){
                    val uid = ""+ds.child("uid").value
                    val name = ""+ds.child("name").value
                    val mobileNo = ""+ds.child("mobileNo").value
                    val about = ""+ds.child("about").value
                    val skills = ""+ds.child("skills").value
                    val position = ""+ds.child("position").value
                    val city = ""+ds.child("city").value
                    val profileImage = ""+ds.child("profileImage").value

                    nameEt?.setText(name)
                    positionEt?.setText(position)
                    mobileNoEt?.setText(mobileNo)
                    aboutMeEt?.setText(about)
                    skillsEt?.setText(skills)
                    cityEt?.setText(city)

                    if (profileIv != null){
                        try {
                            Glide.with(applicationContext).load(profileImage).into(profileIv)
                        }catch (e: Exception){

                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun picImage(){
        CropImage.activity()
                .setMinCropResultSize(400, 400)
                .setMaxCropResultSize(3000, 3000)
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            val result: CropImage.ActivityResult = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK){
                val resultUri = result.uri
                profileIv.setImageURI(resultUri)
                imageUri = resultUri
                val file = File(SiliCompressor.with(applicationContext).compress(FileUtils.getPath(this, imageUri), File(this.cacheDir, "")))
                val fileUri:Uri = Uri.fromFile(file)
                imageUri = fileUri

            }else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                val error = result.error
                Toast.makeText(applicationContext, error?.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun changeProfilePic(){
        if (imageUri != Uri.parse("")) {
            val filePathAndName = "Eduhub_profiles/image_$userUid";
            val storageReference:StorageReference = FirebaseStorage.getInstance().getReference(filePathAndName);
            storageReference.putFile(imageUri)
                    .addOnSuccessListener { taskSnapshot ->
                        val uriTask:Task<Uri> = taskSnapshot.storage.downloadUrl
                        while (!uriTask.isSuccessful) {
                            progressDialog.setMessage("Updating info...")
                            if (uriTask.isSuccessful) {
                                val downloadImageUri: Uri? = uriTask.result
                                val hashMap = HashMap<String, Any>()
                                hashMap["profileImage"] = downloadImageUri.toString()

                                databaseReference.child(userUid).updateChildren(hashMap)
                                        .addOnSuccessListener {
                                            progressDialog.dismiss()
                                            finish()
                                        }.addOnFailureListener {
                                            progressDialog.dismiss()
                                            Toast.makeText(applicationContext, it.message.toString(), Toast.LENGTH_SHORT).show()
                                        }
                            }

                        }


                    }
        }else{
            progressDialog.dismiss()
            finish()
        }
    }

    private fun checkUserStatus(){
        val user = firebaseAuth.currentUser
        if (user != null){
            userUid = user.uid
            userEmail = user.email.toString()
        }else{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}