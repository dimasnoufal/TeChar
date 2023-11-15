package com.unity.techar.discus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.unity.techar.R
import com.unity.techar.berita.BeritaWebActivity

class DiscusActivity : AppCompatActivity() {

    private lateinit var btnDiscus : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discus)

        btnDiscus = findViewById(R.id.btn_discus)
        val linkK = getString(R.string.link)


        btnDiscus.setOnClickListener {
            val i = Intent(this, BeritaWebActivity::class.java)
            i.putExtra(BeritaWebActivity.EXTRA_TEXT, linkK)
            startActivity(i)
        }
    }
}