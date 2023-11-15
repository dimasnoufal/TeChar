package com.unity.techar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.berita.BeritaClass

class BeritaAdapterFragment(private val beritaList: ArrayList<BeritaClass>): RecyclerView.Adapter<BeritaAdapterFragment.ViewHolderClass>()  {

    var onItemClick: ((BeritaClass) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_berita, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: BeritaAdapterFragment.ViewHolderClass, position: Int) {
        val currentItem = beritaList[position]
        holder.rvImageB.setImageResource(currentItem.imageB)
        holder.rvJudulB.text = currentItem.judulB
        holder.rvDeskripsiB.text = currentItem.deskripsiB

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImageB: ImageView = itemView.findViewById(R.id.imageberita)
        val rvJudulB: TextView = itemView.findViewById(R.id.berita)
        val rvDeskripsiB: TextView = itemView.findViewById(R.id.desk)
    }
}