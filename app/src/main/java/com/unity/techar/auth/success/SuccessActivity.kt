package com.unity.techar.auth.success

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unity.techar.R
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}