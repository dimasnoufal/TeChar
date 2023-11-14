package com.unity.techar.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.unity.techar.R
import com.unity.techar.karir.KarirClass

class DetailKarirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_karir)

        val getData = intent.getParcelableExtra<KarirClass>("android")
        if (getData != null){
            val detailGambar : ImageView = findViewById(R.id.image_karir)
            val detailKarir : TextView = findViewById(R.id.namakarir)
            val detailJenis : TextView = findViewById(R.id.jeniskarir)
            val detailGaji : TextView = findViewById(R.id.gaji)
            val detailDeskripsi : TextView = findViewById(R.id.deskripsi)
            val detailKeahlian : TextView = findViewById(R.id.keahlian)

            detailGambar.setImageResource(getData.detail_gambar)
            detailKarir.text = getData.nama
            detailJenis.text = getData.keahlian
            detailGaji.text = getData.gaji
            detailDeskripsi.text = getData.deskripsi
            detailKeahlian.text = getData.detail_keahlian
        }
    }
}