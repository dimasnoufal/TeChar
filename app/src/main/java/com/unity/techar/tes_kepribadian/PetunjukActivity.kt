package com.unity.techar.tes_kepribadian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unity.techar.R
import com.unity.techar.databinding.ActivityPetunjukBinding

class PetunjukActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPetunjukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetunjukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMulai.setOnClickListener {
            startActivity(Intent(this, SoalActivity::class.java))
            finish()
        }
    }
}