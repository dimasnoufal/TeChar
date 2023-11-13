package com.unity.techar.karir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R

class KarirAdapter(private  val karirList: ArrayList<KarirClass>): RecyclerView.Adapter<KarirAdapter.ViewHolderClass>() {


    var onItemClick: ((KarirClass) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_karir, parent, false)
        return  ViewHolderClass(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = karirList[position]
        holder.rvImage.setImageResource(currentItem.gambar)
        holder.rvNama.text = currentItem.nama
        holder.rvKeahlian.text = currentItem.nama

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return karirList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImage:ImageView = itemView.findViewById(R.id.listImageKarir)
        val rvNama:TextView = itemView.findViewById(R.id.listNameKarir)
        val rvKeahlian:TextView = itemView.findViewById(R.id.listKeahlianKarir)
    }
}