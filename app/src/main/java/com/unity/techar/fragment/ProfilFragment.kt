package com.unity.techar.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.unity.techar.R
import com.unity.techar.auth.login.LoginActivity
import com.unity.techar.karir.KarirActivity

class ProfilFragment : Fragment() {
    private lateinit var tvNama: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnKeluar: Button

    var firebaseAuth = FirebaseAuth.getInstance()
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        btnKeluar = view.findViewById(R.id.btn_keluar)

        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser != null) {
            tvNama.text = firebaseUser.displayName
            tvEmail.text = firebaseUser.email
        } else {
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
        }

        btnKeluar.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }
}