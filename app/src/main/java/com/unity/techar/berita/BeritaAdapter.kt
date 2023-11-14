package com.unity.techar.berita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R

class BeritaAdapter(private val beritaList: ArrayList<BeritaClass>): RecyclerView.Adapter<BeritaAdapter.ViewHolderClass>()  {

    var onItemClick: ((BeritaClass) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_berita_next, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: BeritaAdapter.ViewHolderClass, position: Int) {
        val currentItem = beritaList[position]
        holder.rvImageB.setImageResource(currentItem.imageB)
        holder.rvJudulB.text = currentItem.judulB
        holder.rvTanggalB.text = currentItem.tanggalB

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImageB: ImageView = itemView.findViewById(R.id.listImageBerita)
        val rvJudulB: TextView = itemView.findViewById(R.id.listJudulBerita)
        val rvTanggalB: TextView = itemView.findViewById(R.id.listTangalBerita)
    }
}