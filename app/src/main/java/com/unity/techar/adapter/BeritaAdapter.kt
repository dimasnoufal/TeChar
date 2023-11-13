package com.unity.techar.karir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.adapter.BeritaClass

class BeritaAdapter(private  val beritaList: ArrayList<BeritaClass>): RecyclerView.Adapter<BeritaAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_berita, parent, false)
        return  ViewHolderClass(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = beritaList[position]
        holder.rvImageB.setImageResource(currentItem.gambarb)
        holder.rvNamaB.text = currentItem.namab
        holder.rvDeskB.text = currentItem.deskrpisb
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImageB:ImageView = itemView.findViewById(R.id.imageberita)
        val rvNamaB:TextView = itemView.findViewById(R.id.berita)
        val rvDeskB:TextView = itemView.findViewById(R.id.desk)
    }
}