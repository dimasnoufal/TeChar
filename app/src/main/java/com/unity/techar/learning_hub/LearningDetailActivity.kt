package com.unity.techar.learning_hub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.unity.techar.R
import com.unity.techar.adapter.KonsultasiClass
import com.unity.techar.berita.BeritaWebActivity
import com.unity.techar.karir.KarirClass

class LearningDetailActivity : AppCompatActivity() {
    lateinit var link: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_detail)

        val getData = intent.getParcelableExtra<LearningClass>("dicoding")
        if (getData != null){
            val detailGambarL : ImageView = findViewById(R.id.imageLearning)
            val namaLearning : TextView = findViewById(R.id.namaLearning)
            val bidangLearning : TextView = findViewById(R.id.bidangLearning)
            val deskripsiLearning : TextView = findViewById(R.id.deskripsiLearning)

            detailGambarL.setImageResource(getData.detail_gambar)
            namaLearning.text = getData.nama
            bidangLearning.text = getData.ahli
            deskripsiLearning.text = getData.deskripsi
            val linkK = getData.sumber
            link = findViewById(R.id.learning)
            link.setOnClickListener {
                val i = Intent(this, BeritaWebActivity::class.java)
                i.putExtra(BeritaWebActivity.EXTRA_TEXT, linkK)
                startActivity(i)
            }
        }
    }
}