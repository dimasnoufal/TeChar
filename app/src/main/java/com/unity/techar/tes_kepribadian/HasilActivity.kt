package com.unity.techar.tes_kepribadian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.unity.techar.MainActivity
import com.unity.techar.R
import com.unity.techar.quiz_coding.setData

class HasilActivity : AppCompatActivity() {

    private lateinit var Score: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        Score = findViewById(R.id.Scores)
        button = findViewById(R.id.buttons)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        val userName = intent.getStringExtra(setData.name)
        val score = intent.getStringExtra(setData.score)
        val totalQuestions = intent.getStringExtra("total size")

        if (score.toString().toInt() > 3) {
            Score.text= "Sanguinis"
        } else {
            Score.text= "Koleris"
        }
//        congo.text = "Congratulations ${userName} !! \uD83C\uDF89"
//        Score.text= "${score} / ${totalQuestions}"

        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}