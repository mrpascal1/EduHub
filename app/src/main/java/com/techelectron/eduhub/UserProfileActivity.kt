package com.techelectron.eduhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import java.lang.Exception

class UserProfileActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val uid = intent.getStringExtra("userUid").toString()

        firebaseAuth = FirebaseAuth.getInstance()
        val user = FirebaseAuth.getInstance().currentUser
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Users")
        val query = FirebaseDatabase.getInstance().getReference("Users").orderByChild("uid").equalTo(uid)
        query.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children){
                    val uid = ""+ds.child("uid").value
                    val name = ""+ds.child("name").value
                    val email = ""+ds.child("email").value
                    val mobileNo = ""+ds.child("mobileNo").value
                    val about = ""+ds.child("about").value
                    val skills = ""+ds.child("skills").value
                    val position = ""+ds.child("position").value
                    val city = ""+ds.child("city").value
                    val profileImage = ""+ds.child("profileImage").value

                    nameTv?.text = name
                    emailTv?.text = email
                    mobileNoTv?.text = "$mobileNo"
                    aboutTv?.text = about
                    skillsTv?.text = skills
                    positionTv?.text = position
                    cityTv?.text = city
                    if (profileIv != null) {
                        try {
                            Glide.with(applicationContext).load(profileImage).into(profileIv)
                        }catch (e: Exception){

                        }
                    }
                    if (name == ""){
                        nameTv?.text = "-"
                    }
                    if (email == ""){
                        emailTv?.text = "-"
                    }
                    if (mobileNo == ""){
                        mobileNoTv?.text = "-"
                    }
                    if (about == ""){
                        aboutTv?.text = "-"
                    }
                    if (skills == ""){
                        skillsTv?.text = "-"
                    }
                    if (position == ""){
                        positionTv?.text = "-"
                    }
                    if (city == ""){
                        cityTv?.text = "-"
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}