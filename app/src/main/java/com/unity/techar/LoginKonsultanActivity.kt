package com.unity.techar

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.unity.techar.auth.forget_password.ForgetPasswordActivity
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivityLoginBinding
import com.unity.techar.databinding.ActivityLoginKonsultanBinding

class LoginKonsultanActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginKonsultanBinding
    private lateinit var progressDialog: ProgressDialog
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, KonsultanActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginKonsultanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var context = this@LoginKonsultanActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putInt("condition_number", 3)
        editor.apply()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Login")
        progressDialog.setMessage("Silahkan tunggu...")



        binding.loginUser.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text!!.isNotEmpty() && binding.etPassword.text!!.isNotEmpty()) {
                processLogin()
            } else {
                Toast.makeText(this, "Silahkan isi email dan password terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun processLogin() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                startActivity(Intent(this, KonsultanActivity::class.java))
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}