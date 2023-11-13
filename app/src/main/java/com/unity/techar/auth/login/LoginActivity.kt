package com.unity.techar.auth.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.unity.techar.MainActivity
import com.unity.techar.R
import com.unity.techar.auth.forget_password.ForgetPasswordActivity
import com.unity.techar.auth.register.RegisterActivity
import com.unity.techar.databinding.ActivityLoginBinding
import com.unity.techar.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var progressDialog: ProgressDialog
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var context = this@LoginActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putInt("condition_number", 3)
        editor.apply()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Login")
        progressDialog.setMessage("Silahkan tunggu...")

        binding.tvForgetPassword.setOnClickListener {
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
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
                startActivity(Intent(this, MainActivity::class.java))
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}