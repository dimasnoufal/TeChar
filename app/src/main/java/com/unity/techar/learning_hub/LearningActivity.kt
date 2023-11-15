package com.unity.techar.learning_hub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.detail.DetailKarirActivity
import com.unity.techar.karir.KarirAdapter
import com.unity.techar.karir.KarirClass

class LearningActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var learningList: ArrayList<LearningClass>
    lateinit var learningAdapter: LearningAdapter
    lateinit var gambarList:Array<Int>
    lateinit var namaList:Array<String>
    lateinit var ahliList:Array<String>
    lateinit var gambarDetail:Array<Int>
    lateinit var deskripsi:Array<String>
    lateinit var sumber:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)

        gambarList = arrayOf(
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3
        )

        namaList = arrayOf(
            "Data Scientist",
            "Android Developer",
            "Front-End Web",
            "Android Developer",
            "Data Scientist",
            "Android Developer",
            "Front-End Web",
            "Android Developer",
            "Data Scientist",
            "Android Developer"
        )

        ahliList = arrayOf(
            "Dicoding",
            "Google for Developers",
            "Dicoding",
            "Google for Developers",
            "Dicoding",
            "Google for Developers",
            "Dicoding",
            "Google for Developers",
            "Dicoding",
            "Google for Developers"
        )
        gambarDetail = arrayOf(
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3,
            R.drawable.pelatihan_1,
            R.drawable.pelatihan_3
        )

        deskripsi = arrayOf(
            getString(R.string.deskripsiLearning),
            getString(R.string.deskripsiGoogle),
            getString(R.string.deskripsiLearning1),
            getString(R.string.deskripsiGoogle),
            getString(R.string.deskripsiLearning),
            getString(R.string.deskripsiGoogle),
            getString(R.string.deskripsiLearning1),
            getString(R.string.deskripsiGoogle),
            getString(R.string.deskripsiLearning),
            getString(R.string.deskripsiGoogle),
            )

        sumber = arrayOf(
            getString(R.string.linkDicoding),
            getString(R.string.linkGoogle),
            getString(R.string.linkDicoding1),
            getString(R.string.linkGoogle),
            getString(R.string.linkDicoding),
            getString(R.string.linkGoogle),
            getString(R.string.linkDicoding1),
            getString(R.string.linkGoogle),
            getString(R.string.linkDicoding),
            getString(R.string.linkGoogle),
        )

        recyclerView = findViewById(R.id.rvLearning)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        learningList = arrayListOf<LearningClass>()
        getData()

        learningAdapter = LearningAdapter(learningList)
        recyclerView.adapter = learningAdapter

        learningAdapter.onItemClick = {
            val intent = Intent(this, LearningDetailActivity::class.java)
            intent.putExtra("dicoding", it)
            startActivity(intent)
        }
    }

    private fun getData(){
        for (i in gambarList.indices){
            val learningClass = LearningClass(gambarList[i], namaList[i], ahliList[i], gambarDetail[i], deskripsi[i], sumber[i])
            learningList.add(learningClass)
        }
        recyclerView.adapter = LearningAdapter(learningList)
    }
}