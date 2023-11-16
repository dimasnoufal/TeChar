package com.unity.techar.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.unity.techar.R
import com.unity.techar.adapter.KonsultasiClass
import com.unity.techar.berita.BeritaWebActivity
import com.unity.techar.karir.KarirClass

class DetailKonsultasiActivity : AppCompatActivity() {

    lateinit var link: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_konsultasi)

        val getData = intent.getParcelableExtra<KonsultasiClass>("konsultasi")
        if (getData != null){
            val detailGambarK : ImageView = findViewById(R.id.imagekonsultasi)
            val namaKonsultasi : TextView = findViewById(R.id.namakonsultasi)
            val bidangKonsultasi : TextView = findViewById(R.id.bidangkonsultasi)
            val deskripsiKonsultasi : TextView = findViewById(R.id.deskripsikonsultasi)

            detailGambarK.setImageResource(getData.detailgambarK)
            namaKonsultasi.text = getData.namaK
            bidangKonsultasi.text = getData.bidangK
            deskripsiKonsultasi.text = getData.deskripsiK
            val linkK = getString(R.string.link_wa)
            link = findViewById(R.id.konsul)
            link.setOnClickListener {
//                val i = Intent(this, BeritaWebActivity::class.java)
//                i.putExtra(BeritaWebActivity.EXTRA_TEXT, linkK)
//                startActivity(i)

                val web = Intent(Intent.ACTION_VIEW)
                web.setData(Uri.parse(linkK))
                startActivity(web)
            }
        }
    }
}