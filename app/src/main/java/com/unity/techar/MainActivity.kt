package com.unity.techar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var context = this@MainActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putInt("condition_number", 4)
        editor.apply()

        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            binding.tvNama.text = firebaseUser.displayName
            binding.tvEmail.text = firebaseUser.email
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            Intent(this, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

    }
}