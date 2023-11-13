package com.unity.techar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.unity.techar.fragment.HomeFragment
import com.unity.techar.fragment.KonsultasiFragment
import com.unity.techar.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding : ActivityMainBinding
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var context = this@MainActivity
        var sharedPref = context.getSharedPreferences(getString(R.string.condition_state), Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putInt("condition_number", 4)
        editor.apply()

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