package com.unity.techar.auth.forget_password

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.unity.techar.MainActivity
import com.unity.techar.R
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.auth.success.SuccessActivity
import com.unity.techar.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityForgetPasswordBinding
    private lateinit var progressDialog: ProgressDialog
    var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Reset Kata Sandi")
        progressDialog.setMessage("Silahkan tunggu...")

        binding.btnForgetPassword.setOnClickListener {
            if (binding.etEmail.text!!.isNotEmpty()) {
                processReset()
            } else {
                Toast.makeText(this, "Silahkan isi email terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun processReset() {
        val email = binding.etEmail.text.toString().trim()

        progressDialog.show()
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                startActivity(Intent(this, SuccessActivity::class.java))
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}