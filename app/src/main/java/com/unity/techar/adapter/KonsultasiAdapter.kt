package com.unity.techar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.karir.KarirAdapter

class KonsultasiAdapter(private val konsultasiList: ArrayList<KonsultasiClass>): RecyclerView.Adapter<KonsultasiAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KonsultasiAdapter.ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_konsultasi, parent, false)
        return KonsultasiAdapter.ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: KonsultasiAdapter.ViewHolderClass, position: Int) {

        val currentItem = konsultasiList[position]
        holder.rvImageK.setImageResource(currentItem.gambarK)
        holder.rvNamaK.text = currentItem.namaK
        holder.rvBidangK.text = currentItem.bidangK
    }

    override fun getItemCount(): Int {
        return konsultasiList.size
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImageK: ImageView = itemView.findViewById(R.id.listImageKonsultasi)
        val rvNamaK: TextView = itemView.findViewById(R.id.listNameKonsultasi)
        val rvBidangK: TextView = itemView.findViewById(R.id.listBidangKonsultasi)
    }

}