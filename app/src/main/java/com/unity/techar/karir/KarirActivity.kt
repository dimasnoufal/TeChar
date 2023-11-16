package com.unity.techar.karir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import android.content.Intent
import com.unity.techar.detail.DetailKarirActivity

class KarirActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var karirList: ArrayList<KarirClass>
    lateinit var myAdapter: KarirAdapter
    lateinit var gambarList:Array<Int>
    lateinit var namaList:Array<String>
    lateinit var keahlianList:Array<String>
    lateinit var gambarDetail:Array<Int>
    lateinit var gajiDetail:Array<String>
    lateinit var deskripsiDetail:Array<String>
    lateinit var keahlianDetail:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karir)

        gambarList = arrayOf(
            R.drawable.it_career_1,
            R.drawable.it_career_2,
            R.drawable.it_career_3,
            R.drawable.it_career_4,
            R.drawable.it_career_1,
            R.drawable.it_career_2,
            R.drawable.it_career_3,
            R.drawable.it_career_4,
            R.drawable.it_career_1,
            R.drawable.it_career_2
        )

        namaList = arrayOf(
            "Website Development",
            "Android Development",
            "Data Science",
            "Website Development",
            "Android Development",
            "Data Science",
            "Website Development",
            "Android Development",
            "Data Science",
            "Website Development"
        )

        keahlianList = arrayOf(
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
            "Engineering",
        )
        gambarDetail = arrayOf(
            R.drawable.ilustaris_career_1,
            R.drawable.ilustaris_career_2,
            R.drawable.ilustaris_career_3,
            R.drawable.ilustaris_career_1,
            R.drawable.ilustaris_career_2,
            R.drawable.ilustaris_career_3,
            R.drawable.ilustaris_career_1,
            R.drawable.ilustaris_career_2,
            R.drawable.ilustaris_career_3,
            R.drawable.ilustaris_career_1
        )
        gajiDetail = arrayOf(
            getString(R.string.gaji),
            getString(R.string.gaji1),
            getString(R.string.gaji2),
            getString(R.string.gaji),
            getString(R.string.gaji1),
            getString(R.string.gaji2),
            getString(R.string.gaji),
            getString(R.string.gaji1),
            getString(R.string.gaji2),
            getString(R.string.gaji)
        )
        deskripsiDetail = arrayOf(
            getString(R.string.detailDeskripsi),
            getString(R.string.detailDeskripsi1),
            getString(R.string.detailDeskripsi2),
            getString(R.string.detailDeskripsi),
            getString(R.string.detailDeskripsi1),
            getString(R.string.detailDeskripsi2),
            getString(R.string.detailDeskripsi),
            getString(R.string.detailDeskripsi1),
            getString(R.string.detailDeskripsi2),
            getString(R.string.detailDeskripsi)
        )
        keahlianDetail = arrayOf(
            getString(R.string.keahlian),
            getString(R.string.keahlian1),
            getString(R.string.keahlian2),
            getString(R.string.keahlian),
            getString(R.string.keahlian1),
            getString(R.string.keahlian2),
            getString(R.string.keahlian),
            getString(R.string.keahlian1),
            getString(R.string.keahlian2),
            getString(R.string.keahlian)
        )

        recyclerView = findViewById(R.id.rvkarir)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        karirList = arrayListOf<KarirClass>()
        getData()

        myAdapter = KarirAdapter(karirList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailKarirActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }
    private fun getData(){
        for (i in gambarList.indices){
            val karirClass = KarirClass(gambarList[i], namaList[i], keahlianList[i], gambarDetail[i], gajiDetail[i], deskripsiDetail[i], keahlianDetail[i])
            karirList.add(karirClass)
        }
        recyclerView.adapter = KarirAdapter(karirList)
    }

}