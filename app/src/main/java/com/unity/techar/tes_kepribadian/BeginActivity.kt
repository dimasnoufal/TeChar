package com.unity.techar.tes_kepribadian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unity.techar.R
import com.unity.techar.databinding.ActivityBeginBinding

class BeginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBeginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLets.setOnClickListener {
            startActivity(Intent(this, PetunjukActivity::class.java))
            finish()
        }
    }
}