package com.techelectron.eduhub.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.techelectron.eduhub.R
import com.techelectron.eduhub.LoginActivity
import com.techelectron.eduhub.adapters.AdapterPosts
import com.techelectron.eduhub.models.ModelPost
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var userId: String
    lateinit var userEmail: String
    lateinit var postList: ArrayList<ModelPost>
    lateinit var adapterPosts: AdapterPosts

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Posts")
        checkLogin()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postList = ArrayList()
        adapterPosts = AdapterPosts(postList, requireContext())
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerView?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        recyclerView?.adapter = adapterPosts

        searchIv?.setOnClickListener {
            if (searchEt?.visibility == View.VISIBLE){
                searchEt?.visibility = View.GONE
            }else{
                searchEt?.visibility = View.VISIBLE
            }
        }
        searchEt?.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        getPosts(postList, adapterPosts)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getPosts(postList: ArrayList<ModelPost>, adapterPosts: AdapterPosts){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                postList.clear()
                for (ds in snapshot.children){
                    val post = ds.getValue(ModelPost::class.java)
                    if (post != null) {
                        postList.add(post)
                    }
                }
                adapterPosts.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun filter(text: String){
        val filteredTopics = ArrayList<ModelPost>()
        for (s in postList){
            if (s.getpTitle().toLowerCase(Locale.getDefault()).contains(text.toLowerCase(Locale.getDefault()))){
                filteredTopics.add(s)
            }
        }
        adapterPosts.filterList(filteredTopics)
    }

    private fun checkLogin(){
        val user = firebaseAuth.currentUser
        if (user != null){
            userId = user.uid
            userEmail = user.email.toString()
        }else{
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}