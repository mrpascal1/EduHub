package com.techelectron.eduhub

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        setSupportActionBar(toolbar)

        firebaseAuth = FirebaseAuth.getInstance()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("EduHub")
        progressDialog.setMessage("Sending Email")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        recoverBtn.setOnClickListener {
            val email = emailEt.text.toString().trim()
            if (email == ""){
                Toast.makeText(applicationContext, "Please enter email", Toast.LENGTH_SHORT).show()
            }else{
                beginRecovery(email)
            }
        }
    }

    private fun beginRecovery(email: String) {
        progressDialog.show()
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        progressDialog.dismiss()
                        val intent  = Intent(applicationContext, LoginActivity::class.java)
                        intent.putExtra("errorText", "successful")
                        startActivity(intent)
                        finish()
                    }
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, ""+it.message, Toast.LENGTH_SHORT).show()
                }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}