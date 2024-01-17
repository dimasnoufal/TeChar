package com.unity.techar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileKonsultanActivity : AppCompatActivity() {
    private lateinit var tvNama: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnKeluar: Button

    var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_konsultan)

        tvNama = findViewById(R.id.tv_nama)
        tvEmail = findViewById(R.id.tv_email)
        btnKeluar = findViewById(R.id.btn_keluar)

        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser != null) {
            tvNama.text = firebaseUser.displayName
            tvEmail.text = firebaseUser.email
        } else {
            startActivity(Intent(this, LoginKonsultanActivity::class.java))
        }

        btnKeluar.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, LoginKonsultanActivity::class.java))
            finish()
        }
    }
}