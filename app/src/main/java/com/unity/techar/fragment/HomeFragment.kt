package com.unity.techar.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.unity.techar.R
import com.unity.techar.adapter.BeritaClass
import com.unity.techar.karir.BeritaAdapter
import com.unity.techar.karir.KarirActivity
import com.unity.techar.karir.KarirAdapter
import com.unity.techar.karir.KarirClass

class HomeFragment : Fragment() {

    private lateinit var imageslider: ImageSlider
    private lateinit var Skarir: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var karirList: ArrayList<KarirClass>
    lateinit var gambarList:Array<Int>
    lateinit var namaList:Array<String>
    lateinit var keahlianList:Array<String>

    private lateinit var recyclerViewb: RecyclerView
    private lateinit var beritaList: ArrayList<BeritaClass>
    lateinit var gambarBerita:Array<Int>
    lateinit var namaBerita:Array<String>
    lateinit var deskripsiBerita:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        recyclerView = view.findViewById(R.id.rvkarir)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.setHasFixedSize(true)

        karirList = arrayListOf<KarirClass>()
        getData()

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
        imageList.add(SlideModel("https://t3.ftcdn.net/jpg/04/95/28/68/360_F_495286861_E92XpoIILLyv4X8QnROZr9UTInWyj12y.jpg"))
        imageList.add(SlideModel("https://cdn.pixabay.com/photo/2016/08/03/09/03/universe-1566159_640.jpg"))
        imageList.add(SlideModel("https://t4.ftcdn.net/jpg/04/95/28/65/360_F_495286577_rpsT2Shmr6g81hOhGXALhxWOfx1vOQBa.jpg"))

        imageslider.setImageList(imageList, ScaleTypes.CENTER_INSIDE)
    }

    private fun getData(){
        for (i in gambarList.indices){
            val karirClass = KarirClass(gambarList[i], namaList[i], keahlianList[1])
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
