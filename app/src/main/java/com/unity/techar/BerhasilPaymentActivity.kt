package com.unity.techar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BerhasilPaymentActivity : AppCompatActivity() {
    private lateinit var chat : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berhasil_payment)
        chat = findViewById(R.id.btn_chat)
        chat.setOnClickListener {
            val i = Intent(this, ChatActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}