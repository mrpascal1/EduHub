package com.techelectron.eduhub

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_post.*

class AddPostActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var topicReference: DatabaseReference
    lateinit var postReference: DatabaseReference
    lateinit var userId: String
    lateinit var userName: String
    lateinit var userImage: String
    lateinit var userEmail: String

    lateinit var progressDialog: ProgressDialog

    /*lateinit var titleEt: EditText
    lateinit var descriptionEt: EditText
    lateinit var topicNameEt: EditText*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        topicReference = firebaseDatabase.getReference("Topics")
        postReference = firebaseDatabase.getReference("Posts")

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Eduhub")
        progressDialog.setMessage("Adding Post...")
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setCancelable(false)

        userEmail = checkUserStatus()
        getUserDetails()

        var selectedItem = ""
        val allTopics = ArrayList<String>()

        getTopicList(allTopics)
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.select_dialog_item, allTopics)
        topicEt?.threshold = 1
        topicEt?.setAdapter(adapter)

        topicEt?.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            if (item == "Other"){
                topicNameEt.visibility = View.VISIBLE
            }else{
                topicNameEt.visibility = View.GONE
                selectedItem = item
            }
            //selectedItem = item
        }

        postBtn?.setOnClickListener {
            val title = titleEt.text.toString().trim()
            val description = descriptionEt.text.toString().trim()
            if (topicNameEt.visibility == View.VISIBLE) {
                val topicName = topicNameEt.text.toString().trim()
                if (topicName in allTopics) {
                    Toast.makeText(this, "Topic Already Present", Toast.LENGTH_SHORT).show()
                } else {
                    if (title == "" || description == "") {
                        Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                    }else if (topicName == ""){
                        Toast.makeText(this, "Please add topic name", Toast.LENGTH_SHORT).show()
                    }else{
                        addMoreTopic(topicName)
                        addPost(topicName, title, description)
                    }
                }
            }else{
                if (title == "" || description == "" ){
                    Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                }else if (selectedItem == "") {
                    Toast.makeText(this, "Please select a topic", Toast.LENGTH_SHORT).show()
                }else{
                    addPost(selectedItem, title, description)
                }
            }
        }

        topicSpinner?.setOnSpinnerItemSelectedListener<String> { _, item ->
            if (item == "Other"){
                topicNameEt.visibility = View.VISIBLE
            }else{
                topicNameEt.visibility = View.GONE
                selectedItem = item
            }
        }

        backIv.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getTopicList(allTopics: ArrayList<String>) {
        topicReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val topic = ArrayList<String>()
                for (ds in snapshot.children) {
                    val t = "" + ds.value
                    Log.d("DATA", t)
                    topic.add(t)
                    allTopics.add(t)
                }
                topicSpinner?.setItems(topic)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun addMoreTopic(string: String){
        topicReference.push().setValue(string)
    }

    private fun addPost(topic: String, title: String, description: String){
        progressDialog.show()
        val timestamp = System.currentTimeMillis().toString()
        val hashMap = HashMap<Any, String>()
        hashMap["isApproved"] = "false"
        hashMap["uid"] = userId
        hashMap["uName"] = userName
        hashMap["uEmail"] = userEmail
        hashMap["uImage"] = userImage
        hashMap["pid"] = timestamp
        hashMap["pTopic"] = topic
        hashMap["pTitle"] = title
        hashMap["pDescr"] = description
        hashMap["pTime"] = timestamp
        hashMap["pImage"] = ""
        postReference.child(timestamp).setValue(hashMap).addOnSuccessListener {
            Toast.makeText(this, "Post added successfully", Toast.LENGTH_SHORT).show()
            titleEt.setText("")
            descriptionEt.setText("")
            progressDialog.dismiss()
            finish()
        }
    }

    private fun getUserDetails(){
        val userDb = FirebaseDatabase.getInstance().getReference("Users")
        val query = userDb.orderByChild("email").equalTo(userEmail)
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    userName = "" + ds.child("name").value
                    userImage = "" + ds.child("profileImage").value
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun checkUserStatus(): String{
        val user = firebaseAuth.currentUser
        if (user != null){
            userId = user.uid
            userEmail = user.email.toString()
            return userEmail
        }else{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
            return ""
        }
    }
}