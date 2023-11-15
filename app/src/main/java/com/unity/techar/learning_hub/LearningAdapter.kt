package com.unity.techar.learning_hub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R

class LearningAdapter(private val learningList: ArrayList<LearningClass>) : RecyclerView.Adapter<LearningAdapter.ViewHolderClass>() {
    var onItemClick: ((LearningClass) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_learning, parent, false)
        return  ViewHolderClass(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = learningList[position]
        holder.rvImage.setImageResource(currentItem.gambar)
        holder.rvNama.text = currentItem.nama
        holder.rvAhli.text = currentItem.ahli

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return learningList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvImage: ImageView = itemView.findViewById(R.id.listImageLearning)
        val rvNama: TextView = itemView.findViewById(R.id.listNameLearning)
        val rvAhli: TextView = itemView.findViewById(R.id.listAhliLearning)
    }

}