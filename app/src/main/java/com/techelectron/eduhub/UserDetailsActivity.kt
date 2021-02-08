package com.techelectron.eduhub

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Users")
        val intent = intent
        val account: GoogleSignInAccount = intent.getParcelableExtra("account")!!

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("EduHub")
        progressDialog.setMessage("Setting up details...")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        createBtn?.setOnClickListener {
            progressDialog.show()
            val name = nameEt?.text.toString()
            val mobileNo = mobileNoEt?.text.toString()
            firebaseAuthWithGoogle(account, name, mobileNo)
        }
        titleTv?.setOnClickListener {
            onBackPressed()
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount, name: String, mobileNo: String){
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener {
                    val user = firebaseAuth.currentUser
                    if (it.additionalUserInfo!!.isNewUser){
                        val uid = user?.uid.toString()
                        val email = user?.email.toString()
                        completeSignUp(uid, name, email, mobileNo)
                    }
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                }
    }

    private fun completeSignUp(uid: String, name: String, email: String, mobileNo: String){
        val hashMap = HashMap<String, String>()
        hashMap["uid"] = uid
        hashMap["name"] = name
        hashMap["email"] = email
        hashMap["password"] = ""
        hashMap["mobileNo"] = mobileNo
        hashMap["position"] = ""
        hashMap["about"] = ""
        hashMap["skills"] = ""
        hashMap["city"] = ""
        hashMap["profileImage"] = ""

        databaseReference.child(uid).setValue(hashMap)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    val intent = Intent(applicationContext, DashboardActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                }
    }
}