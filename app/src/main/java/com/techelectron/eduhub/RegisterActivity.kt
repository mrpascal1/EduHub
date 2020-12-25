package com.techelectron.eduhub

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.layout_register.*
import kotlin.collections.HashMap

class RegisterActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var user: FirebaseUser

    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("EduHub")
        progressDialog.setMessage("Registering User")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        registerBtn.setOnClickListener {
            val name = nameEt.text.toString().trim()
            val email = emailEt.text.toString().trim()
            val password = passwordEt.text.toString().trim()
            val mobileNo = mobileNoEt.text.toString().trim()
            if (name == "" || email == "" || password == "" || mobileNo == ""){
                errorTv.visibility = View.VISIBLE
            }else {
                progressDialog.show()
                errorTv.visibility = View.GONE
                firebaseAuth.fetchSignInMethodsForEmail(email)
                        .addOnCompleteListener {
                            val isNewUser: Boolean = it.result!!.signInMethods!!.isEmpty()
                            if (isNewUser){
                                signUp(name, email, password, mobileNo)
                            }else{
                                progressDialog.dismiss()
                                errorTv.text = "*Email already registered."
                                errorTv.visibility = View.VISIBLE
                            }
                        }
            }
        }

        alreadyAccTv.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signUp(name: String, email: String, password: String, mobile: String){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful){

                        user = firebaseAuth.currentUser!!

                        val hashMap = HashMap<String, Any>()
                        hashMap["name"] = name
                        hashMap["email"] = email
                        hashMap["password"] = password
                        hashMap["mobileNo"] = mobile
                        hashMap["position"] = ""
                        hashMap["about"] = ""
                        hashMap["skills"] = ""
                        hashMap["city"] = ""
                        hashMap["profileImage"] = ""
                        hashMap["uid"] = user.uid


                        val dbRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")
                        dbRef.child(user.uid).setValue(hashMap)
                                .addOnSuccessListener {
                                    progressDialog.dismiss()
                                    val intent  = Intent(applicationContext, DashboardActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                    }else{
                        progressDialog.dismiss()
                        Toast.makeText(applicationContext, "Registration Failed", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}