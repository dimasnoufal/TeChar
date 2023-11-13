package com.unity.techar.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.adapter.KonsultasiAdapter
import com.unity.techar.adapter.KonsultasiClass
import java.util.Locale

class KonsultasiFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var konsultasiList: ArrayList<KonsultasiClass>
    private lateinit var konsultasiListS: ArrayList<KonsultasiClass>
    lateinit var gambarList:Array<Int>
    lateinit var namaList:Array<String>
    lateinit var bidangList:Array<String>

    private lateinit var txtSemua: TextView
    private lateinit var txtRekomendasi: TextView
    private lateinit var txtPencarian: TextView

    private lateinit var recyclerViewS: RecyclerView
    lateinit var gambarListS:Array<Int>
    lateinit var namaListS:Array<String>
    lateinit var bidangListS:Array<String>

    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<KonsultasiClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konsultasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Rekomendasi
        gambarList = arrayOf(
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher)

        namaList = arrayOf(
            "Ipsum",
            "Lorem",
            "Lorem")

        bidangList = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem")
        recyclerView = view.findViewById(R.id.rvRKonsul)
        searchView = view.findViewById(R.id.search)
        txtPencarian = view.findViewById(R.id.pencarian)
        txtRekomendasi = view.findViewById(R.id.rekomendasi)
        txtSemua = view.findViewById(R.id.semua)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.setHasFixedSize(true)
        konsultasiList = arrayListOf<KonsultasiClass>()
        searchList = arrayListOf<KonsultasiClass>()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    konsultasiList.forEach{
                        if(it.namaK.toLowerCase(Locale.getDefault()).contains(searchText)){
                            searchList.add(it)
                            recyclerViewS.visibility = View.GONE
                            txtPencarian.visibility = View.VISIBLE
                            txtRekomendasi.visibility = View.GONE
                            txtSemua.visibility = View.GONE
                        }else{
                            recyclerViewS.visibility = View.GONE
                            txtPencarian.visibility = View.VISIBLE
                            txtRekomendasi.visibility = View.GONE
                            txtSemua.visibility = View.GONE
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    searchList.clear()
                    searchList.addAll(konsultasiList)
                    recyclerViewS.visibility = View.VISIBLE
                    txtPencarian.visibility = View.GONE
                    txtRekomendasi.visibility = View.VISIBLE
                    txtSemua.visibility = View.VISIBLE
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })


//        semua
        gambarListS = arrayOf(
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher)

        namaListS = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem")

        bidangListS = arrayOf(
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem",
            "Lorem")
        recyclerViewS = view.findViewById(R.id.rvSKonsul)
        recyclerViewS.layoutManager = LinearLayoutManager(requireActivity())
        recyclerViewS.setHasFixedSize(true)
        konsultasiListS = arrayListOf<KonsultasiClass>()
        getDataS()
    }

    private fun getData(){
        for (i in gambarList.indices){
            val konsultasiClass = KonsultasiClass(gambarList[i], namaList[i], bidangList[i])
            konsultasiList.add(konsultasiClass)
        }
        searchList.addAll(konsultasiList)
        recyclerView.adapter = KonsultasiAdapter(searchList)
    }

    private fun getDataS(){
        for (i in gambarListS.indices){
            val konsultasiClass = KonsultasiClass(gambarListS[i], namaListS[i], bidangListS[i])
            konsultasiListS.add(konsultasiClass)
        }
        recyclerViewS.adapter = KonsultasiAdapter(konsultasiListS)
    }
}