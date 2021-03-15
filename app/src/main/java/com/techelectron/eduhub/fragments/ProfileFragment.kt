package com.techelectron.eduhub.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.techelectron.eduhub.EditProfileActivity
import com.techelectron.eduhub.LoginActivity
import com.techelectron.eduhub.R
import com.techelectron.eduhub.adapters.AdapterMyPosts
import com.techelectron.eduhub.models.ModelPost
import kotlinx.android.synthetic.main.fragment_profile.*
import java.lang.Exception

class ProfileFragment : Fragment() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var query: Query
    lateinit var uid: String
    private var googleSignInClient: GoogleSignInClient? = null
    lateinit var postList: ArrayList<ModelPost>
    lateinit var adapterMyPosts: AdapterMyPosts


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        firebaseAuth = FirebaseAuth.getInstance()
        val user = FirebaseAuth.getInstance().currentUser
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Users")

        query = databaseReference.orderByChild("email").equalTo(user?.email)

        checkUserStatus()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build()
        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        //var acct = GoogleSignIn.getLastSignedInAccount(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postList = ArrayList()
        adapterMyPosts = AdapterMyPosts(postList, requireContext())
        val llayoutManager = LinearLayoutManager(requireContext())
        llayoutManager.stackFromEnd = true
        llayoutManager.reverseLayout = true
//        llayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.isNestedScrollingEnabled = false
        recyclerView?.layoutManager = llayoutManager
        recyclerView?.adapter = adapterMyPosts

        moreBtn.setOnClickListener {
            showPopup()
        }

        showDefault()

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
        getUserData()
        getUserPost()
        getNoOfPosts()
    }

    private fun showDefault(){
        userInfoBtn.setTextColor(resources.getColor(R.color.blue))
        postBtn.setTextColor(resources.getColor(R.color.md_grey_500))
        postCard.visibility = View.GONE
        userInfo.visibility = View.VISIBLE
    }

    private fun getUserPost(){
        val ref = FirebaseDatabase.getInstance().getReference("Posts")
        val query = ref.orderByChild("uid").equalTo(uid)
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

    private fun getNoOfPosts(){
        val reference = FirebaseDatabase.getInstance().getReference("Posts")
        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var i = 0
                for (ds in snapshot.children){
                    val post = ds.getValue(ModelPost::class.java)
                    if (post != null && post.uid == uid){
                        i++
                    }
                }
                postCountTv.text = ""+i
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun getUserData(){
        query.addValueEventListener(object: ValueEventListener{
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
                            Glide.with(requireContext()).load(profileImage).placeholder(R.drawable.ic_user_dummy).into(profileIv)
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

    private fun showPopup(){
        val popupMenu = PopupMenu(requireContext(), moreBtn)
        popupMenu.menuInflater.inflate(R.menu.profile_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            if (it.itemId == R.id.editProfile){
                val intent = Intent(requireContext(), EditProfileActivity::class.java)
                startActivity(intent)
            }else if(it.itemId == R.id.signOut){
                firebaseAuth.signOut()
                googleSignInClient?.signOut()?.addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        val intent = Intent(requireContext(), LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }else{
                        Toast.makeText(requireContext(), "SignOut error", Toast.LENGTH_SHORT).show()
                    }
                }

            }
            true
        }
        popupMenu.show()
    }

    private fun checkUserStatus(){
        val user = firebaseAuth.currentUser
        if (user != null){
            uid = user.uid
        }else{
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}