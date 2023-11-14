package com.unity.techar.auth.landing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unity.techar.R
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var context = this@LandingActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putInt("condition_number", 2)
        editor.apply()

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}