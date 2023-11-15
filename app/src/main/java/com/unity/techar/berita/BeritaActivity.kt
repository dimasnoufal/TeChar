package com.unity.techar.berita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.detail.DetailBeritaActivity
import com.unity.techar.detail.DetailKarirActivity
import com.unity.techar.karir.KarirAdapter
import com.unity.techar.karir.KarirClass

class BeritaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var beritaList: ArrayList<BeritaClass>
    lateinit var myAdapter: BeritaAdapter
    lateinit var gambarBList:Array<Int>
    lateinit var judulBList:Array<String>
    lateinit var tanggalBList:Array<String>
    lateinit var detailGambarB:Array<Int>
    lateinit var authorBList:Array<String>
    lateinit var deskripsBList:Array<String>
    lateinit var sumberBList:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        gambarBList = arrayOf(
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1
        )

        judulBList = arrayOf(
            getString(R.string.judulberita),
            getString(R.string.judulberita1),
            getString(R.string.judulberita2),
            getString(R.string.judulberita),
            getString(R.string.judulberita1),
            getString(R.string.judulberita2),
            getString(R.string.judulberita),
            getString(R.string.judulberita1),
            getString(R.string.judulberita2),
            getString(R.string.judulberita)
        )
        tanggalBList = arrayOf(
            "14-November-2023",
            "16-Agustus-2023",
            "15-November-2023",
            "14-November-2023",
            "16-Agustus-2023",
            "15-November-2023",
            "14-November-2023",
            "16-Agustus-2023",
            "15-November-2023",
            "14-November-2023",
        )
        detailGambarB = arrayOf(
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_2,
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_2,
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_2,
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_2,
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_1
        )
        authorBList = arrayOf(
            "Rifki Wuda Sudirman",
            "Mahar Prastiwi dan Dian Ihsan",
            "Yohan",
            "Rifki Wuda Sudirman",
            "Mahar Prastiwi dan Dian Ihsan",
            "Yohan",
            "Rifki Wuda Sudirman",
            "Mahar Prastiwi dan Dian Ihsan",
            "Yohan",
            "Rifki Wuda Sudirman"
        )
        deskripsBList = arrayOf(
            getString(R.string.deskripsiBerita),
            getString(R.string.deskripsiBerita1),
            getString(R.string.deskripsiBerita2),
            getString(R.string.deskripsiBerita),
            getString(R.string.deskripsiBerita1),
            getString(R.string.deskripsiBerita2),
            getString(R.string.deskripsiBerita),
            getString(R.string.deskripsiBerita1),
            getString(R.string.deskripsiBerita2),
            getString(R.string.deskripsiBerita)
        )
        sumberBList = arrayOf(
            getString(R.string.sumber),
            getString(R.string.sumber1),
            getString(R.string.sumber2),
            getString(R.string.sumber),
            getString(R.string.sumber1),
            getString(R.string.sumber2),
            getString(R.string.sumber),
            getString(R.string.sumber1),
            getString(R.string.sumber2),
            getString(R.string.sumber)
        )
        recyclerView = findViewById(R.id.rvberita)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        beritaList = arrayListOf<BeritaClass>()
        getData()

        myAdapter = BeritaAdapter(beritaList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailBeritaActivity::class.java)
            intent.putExtra("berita", it)
            startActivity(intent)
        }
    }
    private fun getData(){
        for (i in gambarBList.indices){
            val beritaClass = BeritaClass(gambarBList[i], judulBList[i], tanggalBList[i], detailGambarB[i], authorBList[i], deskripsBList[i], sumberBList[i])
            beritaList.add(beritaClass)
        }
        recyclerView.adapter = BeritaAdapter(beritaList)
    }
}