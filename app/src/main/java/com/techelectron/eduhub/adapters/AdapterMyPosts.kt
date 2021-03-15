package com.techelectron.eduhub.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.techelectron.eduhub.PostDetailActivity
import com.techelectron.eduhub.R
import com.techelectron.eduhub.models.ModelPost
import kotlinx.android.synthetic.main.my_post_list.view.*

class AdapterMyPosts(private var post: List<ModelPost>, private val context: Context) : RecyclerView.Adapter<AdapterMyPosts.MyHolder>() {
    var processBulb = false
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val bulbRef: DatabaseReference = firebaseDatabase.getReference("Bulbs")
    val myUid = FirebaseAuth.getInstance().currentUser?.uid.toString()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.my_post_list, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindItems(post[position])
        glowBulb(holder, post[position].pid, myUid)

        holder.itemView.titleTv?.setOnClickListener {
            val intent = Intent(context, PostDetailActivity::class.java)
            intent.putExtra("postId", post[position].pid)
            intent.putExtra("myUid", myUid)
            context.startActivity(intent)
        }

        holder.itemView.descriptionTv?.setOnClickListener {
            val intent = Intent(context, PostDetailActivity::class.java)
            intent.putExtra("postId", post[position].pid)
            intent.putExtra("myUid", myUid)
            context.startActivity(intent)
        }

        holder.itemView.glowBtn?.setOnClickListener {
            //val totalBulbs = post[position].pid.toInt()
            processBulb = true
            val postId = post[position].pid.toString()
            bulbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (processBulb){
                        if (snapshot.child(postId).hasChild(myUid)){
                            bulbRef.child(postId).child(myUid).removeValue()
                            processBulb = false
                        }else{
                            bulbRef.child(postId).child(myUid).setValue("Bulbed")
                            processBulb = false
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
            holder.itemView.glowBtn?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_lightbulb_on_64))
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

    private fun glowBulb(holder: MyHolder, postId: String, myUid: String){
        bulbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.child(postId).hasChild(myUid)) {
                    holder.itemView.glowBtn?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_lightbulb_on_64))
                } else {
                    holder.itemView.glowBtn?.setImageDrawable(context.resources.getDrawable(R.drawable.ic_lightbulb_off_64))
                }
                holder.itemView.pGlowTv?.text = "${snapshot.child(postId).childrenCount} Glows"
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
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