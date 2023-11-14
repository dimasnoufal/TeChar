package com.unity.techar.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.unity.techar.R
import com.unity.techar.adapter.BeritaClass
import com.unity.techar.detail.DetailKarirActivity
import com.unity.techar.karir.BeritaAdapter
import com.unity.techar.karir.KarirActivity
import com.unity.techar.karir.KarirAdapter
import com.unity.techar.karir.KarirClass
import com.unity.techar.quiz_coding.WelcomeActivity
import com.unity.techar.tes_kepribadian.BeginActivity

class HomeFragment : Fragment() {

    private lateinit var imageslider: ImageSlider
    private lateinit var Skarir: TextView
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

    private lateinit var recyclerViewb: RecyclerView
    private lateinit var beritaList: ArrayList<BeritaClass>
    lateinit var gambarBerita:Array<Int>
    lateinit var namaBerita:Array<String>
    lateinit var deskripsiBerita:Array<String>

    private lateinit var CvCodeQuiz: CardView
    private lateinit var CvPersonality: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CvCodeQuiz = view.findViewById(R.id.cv_code_quiz)
        CvPersonality = view.findViewById(R.id.cv_personality)

        CvCodeQuiz.setOnClickListener {
            startActivity(Intent(requireActivity(), WelcomeActivity::class.java))
        }

        CvPersonality.setOnClickListener {
            startActivity(Intent(requireActivity(), BeginActivity::class.java))
        }

//        Karir
        gambarList = arrayOf(
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1)

        namaList = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem")

        keahlianList = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem")
        gambarDetail = arrayOf(
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1
        )
        gajiDetail = arrayOf(
            getString(R.string.gaji),
            getString(R.string.gaji1),
            getString(R.string.gaji1)
        )
        deskripsiDetail = arrayOf(
            getString(R.string.detailDeskripsi),
            getString(R.string.detailDeskripsi1),
            getString(R.string.detailDeskripsi2)
        )
        keahlianDetail = arrayOf(
            getString(R.string.keahlian),
            getString(R.string.keahlian1),
            getString(R.string.keahlian2)
        )

        recyclerView = view.findViewById(R.id.rvkarir)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.setHasFixedSize(true)

        karirList = arrayListOf<KarirClass>()
        getData()
        myAdapter = KarirAdapter(karirList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(requireActivity(), DetailKarirActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }

//        berita
        gambarBerita = arrayOf(
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1,
            R.drawable.icon_1)

        namaBerita = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem")

        deskripsiBerita = arrayOf(
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.")

        recyclerViewb = view.findViewById(R.id.rvberita)
        recyclerViewb.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL ,false)
        recyclerViewb.setHasFixedSize(true)

        beritaList = arrayListOf<BeritaClass>()
        getDataBerita()


        Skarir = view.findViewById(R.id.selenkapnyakarir)
        imageslider = view.findViewById(R.id.image_slider)

        Skarir.setOnClickListener{
            startActivity(Intent(requireActivity(), KarirActivity::class.java))
        }

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner_1))
        imageList.add(SlideModel(R.drawable.banner_2))
        imageList.add(SlideModel(R.drawable.banner_3))

        imageslider.setImageList(imageList, ScaleTypes.CENTER_INSIDE)
    }

    private fun getData(){
        for (i in gambarList.indices){
            val karirClass = KarirClass(gambarList[i], namaList[i], keahlianList[1], gambarDetail[i], gajiDetail[i], deskripsiDetail[i], keahlianDetail[i])
            karirList.add(karirClass)
        }
        recyclerView.adapter = KarirAdapter(karirList)
    }

    private fun getDataBerita(){
        for (i in gambarBerita.indices){
            val beritaClass = BeritaClass(gambarBerita[i], namaBerita[i], deskripsiBerita[1])
            beritaList.add(beritaClass)
        }
        recyclerViewb.adapter = BeritaAdapter(beritaList)
    }
}
