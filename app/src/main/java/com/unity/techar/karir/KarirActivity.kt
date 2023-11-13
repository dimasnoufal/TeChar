package com.unity.techar.karir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R

class KarirActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var karirList: ArrayList<KarirClass>
    lateinit var gambarList:Array<Int>
    lateinit var namaList:Array<String>
    lateinit var keahlianList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karir)

        gambarList = arrayOf(
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1)

        namaList = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem")

        keahlianList = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem")

        recyclerView = findViewById(R.id.rvkarir)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        karirList = arrayListOf<KarirClass>()
        getData()
    }
    private fun getData(){
        for (i in gambarList.indices){
            val karirClass = KarirClass(gambarList[i], namaList[i], keahlianList[1])
            karirList.add(karirClass)
        }
        recyclerView.adapter = KarirAdapter(karirList)
    }

}