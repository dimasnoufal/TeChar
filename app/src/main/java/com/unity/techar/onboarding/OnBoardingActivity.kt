package com.unity.techar.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.unity.techar.R
import com.unity.techar.auth.landing.LandingActivity
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.onboarding.data.Page
import com.unity.techar.utils.gone
import com.unity.techar.utils.visible

class OnBoardingActivity : AppCompatActivity() {

    private val onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when (position){
                0 -> {
                    skipBtn.text = "Skip"
                    skipBtn.visible()
                    nextBtn.visible()
                    previousBtn.gone()
                    startedBtn.gone()
                }
                pagerList.size - 1 -> {
//                    skipBtn.text = "Get Started"
                    nextBtn.gone()
                    skipBtn.gone()
                    previousBtn.gone()
                    startedBtn.visible()

                }
                else -> {
                    skipBtn.text = "Skip"
                    skipBtn.visible()
                    nextBtn.visible()
                    previousBtn.gone()
                    startedBtn.gone()
                }
            }
        }
    }

    private val pagerList = arrayListOf(
        Page(
            "Ketauhi jenis kepribadian",
            R.drawable.programming_amico,
            "Kenali dirimu melalui tes kepribadian yang dirancang untuk menggali potensi dan memahami diri.",
            "#FFFFFF"
        ),
        Page(
            "Dapatkan Informasi Karir dan Pelatihan bidang IT",
            R.drawable.on_boarding_2,
            "Temukan karir IT yang tepat untuk anda dengan informasi dan pelatihan yang tepat",
            "#FFFFFF"
        ),
        Page(
            "Konsultasi dengan HR",
            R.drawable.on_boarding_3,
            "Optimalkan potensi karir Anda dengan konsultasi HR",
            "#FFFFFF"
        )
    )

    lateinit var onBoardingViewPager2 : ViewPager2
    lateinit var skipBtn : Button
    lateinit var nextBtn : ImageView
    lateinit var previousBtn : Button
    lateinit var startedBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        var context = this@OnBoardingActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putInt("condition_number", 1)
        editor.apply()

        onBoardingViewPager2= findViewById(R.id.onBoardingViewPager2)
        skipBtn= findViewById(R.id.skipBtn)
        nextBtn= findViewById(R.id.nextBtn)
        previousBtn= findViewById(R.id.previousBtn)
        startedBtn= findViewById(R.id.startedBtn)

        onBoardingViewPager2.apply {
            adapter = OnBoardingAdapter(this@OnBoardingActivity,pagerList)
            registerOnPageChangeCallback(onBoardingPageChangeCallback)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout,onBoardingViewPager2){tab, position -> }.attach()


        nextBtn.setOnClickListener {
            if (onBoardingViewPager2.currentItem < onBoardingViewPager2.adapter!!.itemCount- 1){
                onBoardingViewPager2.currentItem += 1
            }else{
                homeScreenIntent()
            }
        }

        skipBtn.setOnClickListener {
            homeScreenIntent()
        }

        previousBtn.setOnClickListener {
            if (onBoardingViewPager2.currentItem > 0){
                onBoardingViewPager2.currentItem -= 1
            }
        }

        startedBtn.setOnClickListener {
            homeScreenIntent()
        }

    }

    override fun onDestroy() {
        onBoardingViewPager2.unregisterOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }
    private fun homeScreenIntent() {
//        val sharedPreferenceManger = SharedPreferenceManger(this)
//        sharedPreferenceManger.isFirstTime = false
        val homeIntent = Intent(this,LandingActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}