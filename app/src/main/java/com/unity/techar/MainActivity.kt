package com.unity.techar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.unity.techar.fragment.HomeFragment
import com.unity.techar.fragment.KonsultasiFragment
import com.unity.techar.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home ->{
                    repleaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_konsultasi ->{
                    repleaceFragment(KonsultasiFragment())
                    true
                }
                R.id.bottom_profil ->{
                    repleaceFragment(ProfilFragment())
                    true
                }
                else -> false
            }
        }
        repleaceFragment(HomeFragment())
    }

    private fun repleaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}