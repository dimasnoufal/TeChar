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
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1
        )

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
            "Lorem"
        )

        ahliList = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem"
        )
        gambarDetail = arrayOf(
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1
        )

        deskripsi = arrayOf(
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
        )

        sumber = arrayOf(
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
            "https://www.dicoding.com",
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