package com.unity.techar.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.unity.techar.R
import com.unity.techar.berita.BeritaAdapter
import com.unity.techar.berita.BeritaClass
import com.unity.techar.berita.BeritaWebActivity

class DetailBeritaActivity : AppCompatActivity() {


    lateinit var buttonberita: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val getData = intent.getParcelableExtra<BeritaClass>("berita")
        if (getData != null){
            val detailGambarB : ImageView = findViewById(R.id.image_berita)
            val detailJudulB : TextView = findViewById(R.id.judulberita)
            val detailAuthorB : TextView = findViewById(R.id.namaauthor)
            val detailTanggalB : TextView = findViewById(R.id.tanggal)
            val detailDeskripsiB : TextView = findViewById(R.id.deskripsiberita)
            val detailSumberB : TextView = findViewById(R.id.sumberberita)

            detailGambarB.setImageResource(getData.detail_imageB)
            detailJudulB.text = getData.judulB
            detailTanggalB.text = getData.tanggalB
            detailAuthorB.text = getData.authorB
            detailDeskripsiB.text = getData.deskripsiB
            detailSumberB.text = getData.sumberB
            val berita = getData.sumberB
            buttonberita = findViewById(R.id.beritaweb)
            buttonberita.setOnClickListener {
                val i = Intent(this, BeritaWebActivity::class.java)
                i.putExtra(BeritaWebActivity.EXTRA_TEXT, berita)
                startActivity(i)
            }
        }


    }
}