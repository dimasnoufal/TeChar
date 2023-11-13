package com.unity.techar.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unity.techar.MainActivity
import com.unity.techar.R
import com.unity.techar.auth.landing.LandingActivity
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivitySplashBinding
import com.unity.techar.onboarding.OnBoardingActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var context = this@SplashActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        var currentNumberCondition = sharedPref.getInt("condition_number", 0)

        // Condition number info
        // 0 = Default number
        // 1 = On boarding number
        // 2 = Landing number
        // 3 = Login number
        // 4 = Home number

        if (currentNumberCondition == 0) {
            binding.ivSplash.alpha = 0f
            binding.ivSplash.animate().setDuration(2000).alpha(1f).withEndAction {
                startActivity(Intent(this, OnBoardingActivity::class.java))
                finish()
            }
        } else if (currentNumberCondition == 1) {
            binding.ivSplash.alpha = 0f
            binding.ivSplash.animate().setDuration(2000).alpha(1f).withEndAction {
                startActivity(Intent(this, OnBoardingActivity::class.java))
                finish()
            }
        } else if (currentNumberCondition == 2) {
            binding.ivSplash.alpha = 0f
            binding.ivSplash.animate().setDuration(2000).alpha(1f).withEndAction {
                startActivity(Intent(this, LandingActivity::class.java))
                finish()
            }
        } else if (currentNumberCondition == 3) {
            binding.ivSplash.alpha = 0f
            binding.ivSplash.animate().setDuration(2000).alpha(1f).withEndAction {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else if (currentNumberCondition == 4) {
            binding.ivSplash.alpha = 0f
            binding.ivSplash.animate().setDuration(2000).alpha(1f).withEndAction {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}