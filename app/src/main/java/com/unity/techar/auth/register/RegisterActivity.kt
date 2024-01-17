package com.unity.techar.auth.register

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.unity.techar.MainActivity
import com.unity.techar.R
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var progressDialog: ProgressDialog
    var firebaseAuth = FirebaseAuth.getInstance()

    private lateinit var databaseReference: DatabaseReference

    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Register")
        progressDialog.setMessage("Silahkan tunggu...")

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {

            val userName = binding.etFullName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if (binding.etFullName.text!!.isNotEmpty() && binding.etEmail.text!!.isNotEmpty() && binding.etPassword.text!!.isNotEmpty()) {
                if (binding.etPassword.text.toString() == binding.etConfirmPassword.text.toString()) {
                    // Launch Register
//                    processRegister()
                    registerUser(userName,email,password)
                } else {
                   Toast.makeText(this, "Konfirmasi kata sandi harus sama", LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Silahkan isi data dengan benar!", LENGTH_SHORT).show()
            }
        }
    }

//    private fun processRegister() {
//        val fullName = binding.etFullName.text.toString().trim()
//        val email = binding.etEmail.text.toString().trim()
//        val password = binding.etPassword.text.toString().trim()
//
//        progressDialog.show()
//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val userUpdateProfile = userProfileChangeRequest {
//                        displayName = fullName
//                    }
//
//                    val user = task.result.user
//                    user!!.updateProfile(userUpdateProfile)
//                        .addOnCompleteListener {
//                            progressDialog.dismiss()
//                            startActivity(Intent(this, LoginActivity::class.java))
//                        }
//                        .addOnFailureListener { error2 ->
//                            Toast.makeText(this, error2.localizedMessage, LENGTH_SHORT).show()
//                        }
//                }
//                else {
//                    progressDialog.dismiss()
////                    Toast.makeText(this, "Pendaftaran gagal", LENGTH_SHORT).show()
//                }
//            }
//            .addOnFailureListener { error ->
//                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
//            }
//    }
private fun registerUser(userName:String,email:String,password:String){
    firebaseAuth.createUserWithEmailAndPassword(email,password)
        .addOnCompleteListener(this){
            if (it.isSuccessful){
                val user: FirebaseUser? = firebaseAuth.currentUser
                val userId:String = user!!.uid

                databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId)

                val hashMap:HashMap<String,String> = HashMap()
                hashMap.put("userId",userId)
                hashMap.put("userName",userName)

                databaseReference.setValue(hashMap).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        //open home activity
                        binding.etFullName.setText("")
                        binding.etEmail.setText("")
                        binding.etPassword.setText("")
                        binding.etConfirmPassword.setText("")
                        val intent = Intent(this,
                            LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
}
}