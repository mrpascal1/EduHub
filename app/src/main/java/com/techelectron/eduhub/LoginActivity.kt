package com.techelectron.eduhub

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth

    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("EduHub")
        progressDialog.setMessage("Logging In")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        loginBtn.setOnClickListener {
            val email = emailEt.text.toString().trim()
            val password = passwordEt.text.toString().trim()

            if (email == "" || password == ""){
                errorTv.text = "*All fields are mandatory."
                errorTv.setTextColor(resources.getColor(R.color.red))
                errorTv.visibility = View.VISIBLE
            }else{
                errorTv.visibility = View.GONE
                progressDialog.show()
                login(email, password)
            }
        }

        noAccTv.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        forgotPassTv.setOnClickListener {
            val email = emailEt.text.toString().trim()
            if (email == ""){
                errorTv.text = "*Please enter email."
                errorTv.setTextColor(resources.getColor(R.color.red))
                errorTv.visibility = View.VISIBLE
            }else{
                errorTv.visibility = View.GONE
                progressDialog.setMessage("Sending email...")
                progressDialog.show()
                beginRecovery(email)
            }
        }
    }

    private fun beginRecovery(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        progressDialog.dismiss()
                        errorTv.text = "*Recovery link sent to email."
                        errorTv.setTextColor(resources.getColor(R.color.green))
                        errorTv.visibility = View.VISIBLE

                    }
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, ""+it.message, Toast.LENGTH_SHORT).show()
                }
    }

    private fun login(email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
            if (it.isSuccessful){
                progressDialog.dismiss()
                val intent  = Intent(applicationContext, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                progressDialog.dismiss()
                errorTv.text = "*Email or password does not matched."
                errorTv.setTextColor(resources.getColor(R.color.red))
                errorTv.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "Authentication error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}