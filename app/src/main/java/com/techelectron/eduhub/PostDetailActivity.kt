package com.techelectron.eduhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetailActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference
    lateinit var query: Query
    var postId = ""
    var myUid = ""
    var userUid = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val intent = intent
        postId = intent.getStringExtra("postId").toString()
        myUid = intent.getStringExtra("myUid").toString()

        firebaseAuth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("Posts")
        query = databaseReference.orderByChild("pid").equalTo(postId)

        loadPost()
        getBulbs()

        glowBtn?.setOnClickListener {
            setBulb()
        }

        backIv?.setOnClickListener {
            onBackPressed()
        }

        uNameTv?.setOnClickListener {
            val userProfile = Intent(this, UserProfileActivity::class.java)
            userProfile.putExtra("userUid", userUid)
            startActivity(userProfile)
        }
    }

    private fun loadPost(){
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children){
                    val uid = "" + ds.child("uid").value
                    val pid = "" + ds.child("pid").value
                    val uName = "" + ds.child("uName").value
                    val topic = "" + ds.child("pTopic").value
                    val title = "" + ds.child("pTitle").value
                    val description = "" + ds.child("pDescr").value
                    val timestamp = "" + ds.child("pTime").value

                    uNameTv?.text = "by $uName"
                    topicTv?.text = topic
                    titleTv?.text = title
                    descriptionTv?.text = description
                    userUid = uid
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun setBulb(){
        var processBulb = true
        val bulbRef = FirebaseDatabase.getInstance().getReference("Bulbs")
        bulbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (processBulb) {
                    if (snapshot.child(postId).hasChild(myUid)) {
                        bulbRef.child(postId).child(myUid).removeValue()
                        processBulb = false
                    } else {
                        bulbRef.child(postId).child(myUid).setValue("Bulbed")
                        processBulb = false
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun getBulbs(){
        val bulbRef = FirebaseDatabase.getInstance().getReference("Bulbs")
        bulbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.child(postId).hasChild(myUid)){
                    glowBtn?.setImageDrawable(resources.getDrawable(R.drawable.ic_lightbulb_on_64))
                }else{
                    glowBtn?.setImageDrawable(resources.getDrawable(R.drawable.ic_lightbulb_off_64))
                }
                pGlowTv?.text = "${snapshot.child(postId).childrenCount} Glows"
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }


    private fun checkUserStatus(){

    }
}