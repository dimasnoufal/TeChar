package com.unity.techar.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unity.techar.R
import com.unity.techar.User
import com.unity.techar.ChatActivity
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(private val context: Context, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layoutUser:LinearLayout = view.findViewById(R.id.layoutUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}