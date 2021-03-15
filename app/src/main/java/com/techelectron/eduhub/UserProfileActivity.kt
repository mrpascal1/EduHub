package com.techelectron.eduhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.techelectron.eduhub.adapters.AdapterMyPosts
import com.techelectron.eduhub.models.ModelPost
import kotlinx.android.synthetic.main.activity_user_profile.*
import java.lang.Exception

class UserProfileActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    var userId = ""
    lateinit var postList: ArrayList<ModelPost>
    lateinit var adapterMyPosts: AdapterMyPosts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val uid = intent.getStringExtra("userUid").toString()
        userId = uid
        firebaseAuth = FirebaseAuth.getInstance()
        val user = FirebaseAuth.getInstance().currentUser
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Users")

        postList = ArrayList()
        adapterMyPosts = AdapterMyPosts(postList, this)
        val llayoutManager = LinearLayoutManager(this)
        llayoutManager.stackFromEnd = true
        llayoutManager.reverseLayout = true
//        llayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.isNestedScrollingEnabled = false
        recyclerView?.layoutManager = llayoutManager
        recyclerView?.adapter = adapterMyPosts

        getUserInfo()
        showDefault()
        getUserPost()
        getNoOfPosts()

        userInfoBtn?.setOnClickListener {
            if (userInfo.visibility == View.GONE){
                userInfoBtn.setTextColor(resources.getColor(R.color.blue))
                postBtn.setTextColor(resources.getColor(R.color.md_grey_500))
                postCard.visibility = View.GONE
                userInfo.visibility = View.VISIBLE
            }
        }

        postBtn?.setOnClickListener {
            if (postCard.visibility == View.GONE){
                postBtn.setTextColor(resources.getColor(R.color.blue))
                userInfoBtn.setTextColor(resources.getColor(R.color.md_grey_500))
                userInfo.visibility = View.GONE
                postCard.visibility = View.VISIBLE
            }
        }

        backIv?.setOnClickListener {
            onBackPressed()
        }

    }

    private fun showDefault(){
        userInfoBtn.setTextColor(resources.getColor(R.color.blue))
        postBtn.setTextColor(resources.getColor(R.color.md_grey_500))
        postCard.visibility = View.GONE
        userInfo.visibility = View.VISIBLE
    }

    private fun getNoOfPosts(){
        val reference = FirebaseDatabase.getInstance().getReference("Posts")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var i = 0
                for (ds in snapshot.children){
                    val post = ds.getValue(ModelPost::class.java)
                    if (post != null && post.uid == userId){
                        i++
                    }
                }
                postCountTv?.text = "" + i
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun getUserPost(){
        val ref = FirebaseDatabase.getInstance().getReference("Posts")
        val query = ref.orderByChild("uid").equalTo(userId)
        query.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                postList.clear()
                for (ds in snapshot.children){
                    val myPosts = ds.getValue(ModelPost::class.java)
                    if (myPosts != null) {
                        Log.d("TAG", myPosts.toString())
                        postList.add(myPosts)
                    }
                }
                adapterMyPosts.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun getUserInfo(){
        val query = FirebaseDatabase.getInstance().getReference("Users").orderByChild("uid").equalTo(userId)
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
                            Glide.with(applicationContext).load(profileImage).placeholder(R.drawable.ic_user_dummy).into(profileIv)
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