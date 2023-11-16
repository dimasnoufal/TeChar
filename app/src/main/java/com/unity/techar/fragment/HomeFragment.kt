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
import com.unity.techar.berita.BeritaClass
import com.unity.techar.berita.BeritaActivity
import com.unity.techar.detail.DetailBeritaActivity
import com.unity.techar.detail.DetailKarirActivity
import com.unity.techar.discus.DiscusActivity
import com.unity.techar.adapter.BeritaAdapterFragment
import com.unity.techar.karir.KarirActivity
import com.unity.techar.karir.KarirAdapter
import com.unity.techar.karir.KarirClass
import com.unity.techar.learning_hub.LearningActivity
import com.unity.techar.quiz_coding.WelcomeActivity
import com.unity.techar.tes_kepribadian.BeginActivity

class HomeFragment : Fragment() {

    private lateinit var imageslider: ImageSlider
    private lateinit var Skarir: TextView
    private lateinit var SBerita: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var karirList: ArrayList<KarirClass>
    lateinit var myAdapter: KarirAdapter
    lateinit var bAdapter: BeritaAdapterFragment
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
    lateinit var detailGambarB:Array<Int>
    lateinit var authorBList:Array<String>
    lateinit var sumberBList:Array<String>
    lateinit var tanggalBList:Array<String>

    private lateinit var CvCodeQuiz: CardView
    private lateinit var CvPersonality: CardView
    private lateinit var cvDiscus: CardView
    private lateinit var cvItCareer: CardView
    private lateinit var cvNews : CardView
    private lateinit var cvLearningHub: CardView

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
        cvDiscus = view.findViewById(R.id.cv_discus)
        cvItCareer = view.findViewById(R.id.cv_it_career)
        cvNews = view.findViewById(R.id.cv_news)
        cvLearningHub = view.findViewById(R.id.cv_learning_hub)

        CvCodeQuiz.setOnClickListener {
            startActivity(Intent(requireActivity(), WelcomeActivity::class.java))
        }

        CvPersonality.setOnClickListener {
            startActivity(Intent(requireActivity(), BeginActivity::class.java))
        }

        cvDiscus.setOnClickListener {
            startActivity(Intent(requireActivity(), DiscusActivity::class.java))
        }

        cvItCareer.setOnClickListener {
            startActivity(Intent(requireActivity(), KarirActivity::class.java))
        }

        cvNews.setOnClickListener {
            startActivity(Intent(requireActivity(), BeritaActivity::class.java))
        }

        cvLearningHub.setOnClickListener {
            startActivity(Intent(requireActivity(), LearningActivity::class.java))
        }

//        Karir
        gambarList = arrayOf(
            R.drawable.it_career_1,
            R.drawable.it_career_2,
            R.drawable.it_career_3)

        namaList = arrayOf(
            "Website Development",
            "Data Science",
            "Android Development")

        keahlianList = arrayOf(
            "Engineering",
            "Engineering",
            "Engineering")
        gambarDetail = arrayOf(
            R.drawable.ilustaris_career_1,
            R.drawable.ilustaris_career_2,
            R.drawable.ilustaris_career_3
        )
        gajiDetail = arrayOf(
            getString(R.string.gaji),
            getString(R.string.gaji2),
            getString(R.string.gaji1)
        )
        deskripsiDetail = arrayOf(
            getString(R.string.detailDeskripsi),
            getString(R.string.detailDeskripsi2),
            getString(R.string.detailDeskripsi1)
        )
        keahlianDetail = arrayOf(
            getString(R.string.keahlian),
            getString(R.string.keahlian2),
            getString(R.string.keahlian1)
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
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1,
            R.drawable.icon_news_1)

        namaBerita = arrayOf(
            getString(R.string.judulberita),
            getString(R.string.judulberita1),
            getString(R.string.judulberita2),
            getString(R.string.judulberita))


        deskripsiBerita = arrayOf(
            getString(R.string.deskripsiBerita),
            getString(R.string.deskripsiBerita1),
            getString(R.string.deskripsiBerita2),
            getString(R.string.deskripsiBerita))

        detailGambarB = arrayOf(
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_2,
            R.drawable.ilustrasi_news_1,
            R.drawable.ilustrasi_news_2
        )
        tanggalBList = arrayOf(
            "14-November-2023",
            "16-Agustus-2023",
            "15-November-2023",
            "14-November-2023"
        )
        authorBList = arrayOf(
            "Rifki Wuda Sudirman",
            "Mahar Prastiwi dan Dian Ihsan",
            "Yohan",
            "Rifki Wuda Sudirman"
        )



        sumberBList = arrayOf(
            getString(R.string.sumber),
            getString(R.string.sumber1),
            getString(R.string.sumber2),
            getString(R.string.sumber)
        )

        recyclerViewb = view.findViewById(R.id.rvberitab)
        recyclerViewb.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL ,false)
        recyclerViewb.setHasFixedSize(true)

        beritaList = arrayListOf<BeritaClass>()
        getDataBerita()
        bAdapter = BeritaAdapterFragment(beritaList)
        recyclerViewb.adapter = bAdapter

        bAdapter.onItemClick = {
            val intentB = Intent(requireActivity(), DetailBeritaActivity::class.java)
            intentB.putExtra("berita", it)
            startActivity(intentB)
        }


        Skarir = view.findViewById(R.id.selenkapnyakarir)
        SBerita = view.findViewById(R.id.selenkapnyaberita)
        imageslider = view.findViewById(R.id.image_slider)

        Skarir.setOnClickListener{
            startActivity(Intent(requireActivity(), KarirActivity::class.java))
        }

        SBerita.setOnClickListener{
            startActivity(Intent(requireActivity(), BeritaActivity::class.java))
        }

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner_1))
        imageList.add(SlideModel(R.drawable.banner_2))
        imageList.add(SlideModel(R.drawable.banner_4))

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
            val beritaClass = BeritaClass(gambarBerita[i], namaBerita[i], tanggalBList[1], detailGambarB[i], authorBList[i], deskripsiBerita[i], sumberBList[i])
            beritaList.add(beritaClass)
        }
        recyclerViewb.adapter = BeritaAdapterFragment(beritaList)
    }
}
