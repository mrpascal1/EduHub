package com.techelectron.eduhub.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.techelectron.eduhub.BuildConfig
import com.techelectron.eduhub.R
import com.techelectron.eduhub.UserProfileActivity
import com.techelectron.eduhub.models.ModelPost
import kotlinx.android.synthetic.main.post_list.view.*


class AdapterPosts(private var post: List<ModelPost>, private val context: Context) :
    RecyclerView.Adapter<AdapterPosts.MyHolder>() {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference: DatabaseReference = firebaseDatabase.getReference("Posts")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.post_list, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindItems(post[position])
        if (post[position].isApproved == "false"){
            holder.itemView.approvalTv?.visibility = View.VISIBLE
        }else{
            holder.itemView.approvalTv?.visibility = View.GONE
        }

        holder.itemView.titleTv?.setOnClickListener {
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra("userUid", post[position].uid)
            context.startActivity(intent)
        }

        holder.itemView.shareBtn?.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "EduHub")
            var shareMessage = "Topic: " + post[position].getpTitle() + "\n\nSolution: " + post[position].getpDescr() + "\n\nLearn with me at EduHub\n\n"
            shareMessage = "${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            context.startActivity(Intent.createChooser(shareIntent, "choose one"))
        }
    }

    override fun getItemCount(): Int {
        return post.size
    }

    fun filterList(filteredNames: List<ModelPost>){
        post = filteredNames
        notifyDataSetChanged()
    }

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(post: ModelPost){
            val topicTv = itemView.findViewById<TextView>(R.id.topicTv)
            val titleTv = itemView.findViewById<TextView>(R.id.titleTv)
            val descriptionTv = itemView.findViewById<TextView>(R.id.descriptionTv)
            val uNameTv = itemView.findViewById<TextView>(R.id.uNameTv)

            topicTv.text = post.getpTopic()
            titleTv.text = post.getpTitle()
            descriptionTv.text = post.getpDescr()
            uNameTv.text = "by " + post.getuName()
        }
    }
}