package com.unity.techar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TransaksiActivity : AppCompatActivity() {
    private lateinit var payment : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        payment = findViewById(R.id.payment)

        payment.setOnClickListener {
            val i = Intent(this, BerhasilPaymentActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}