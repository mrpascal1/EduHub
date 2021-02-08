package com.techelectron.eduhub

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    private var googleSignInClient: GoogleSignInClient? = null
    var RC_SIGN_IN = 1
    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*if (BuildConfig.DEBUG){
            nSignIn?.visibility = View.VISIBLE
            gSignIn?.visibility = View.GONE
        }else{
            gSignIn?.visibility = View.VISIBLE
            nSignIn?.visibility = View.GONE
        }*/

        if (BuildConfig.DEBUG){
            gSignIn?.visibility = View.VISIBLE
            nSignIn?.visibility = View.GONE
        }else{
            gSignIn?.visibility = View.VISIBLE
            nSignIn?.visibility = View.GONE
        }

        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("EduHub")
        progressDialog.setMessage("Logging In")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        googleBtn?.setOnClickListener {
            progressDialog.show()
            signIn()
        }

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
                    Toast.makeText(applicationContext, "" + it.message, Toast.LENGTH_SHORT).show()
                }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient?.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                val email = account.email.toString()
                Log.d("TAG", email)
                val intent = Intent(applicationContext, UserDetailsActivity::class.java)
                firebaseAuth.fetchSignInMethodsForEmail(email)
                        .addOnCompleteListener {
                            val isNewUser = it.result?.signInMethods?.isEmpty()
                            if (isNewUser == false){
                                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                                firebaseAuth.signInWithCredential(credential)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful){
                                                progressDialog.dismiss()
                                                //val user = firebaseAuth.currentUser
                                                val dashboardActivity = Intent(applicationContext, DashboardActivity::class.java)
                                                dashboardActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                                startActivity(dashboardActivity)
                                            }else{
                                            }
                                        }
                            }else{
                                progressDialog.dismiss()
                                intent.putExtra("account", account)
                                startActivity(intent)
                            }
                        }

                //firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                progressDialog.dismiss()
                Log.d("TAG", e.message.toString())
            }
        }
    }

    /*private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = firebaseAuth.currentUser

                    } else {
                        // If sign in fails, display a message to the user.
                    }
                    // ...
                }
    }*/

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