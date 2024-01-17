package com.unity.techar.berita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.unity.techar.R

class BeritaWebActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TEXT = "beritaW"
    }
    lateinit var berita: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_web)
        var web = intent.getStringExtra(EXTRA_TEXT)
        berita = findViewById(R.id.beritawebs)
        berita.webViewClient = WebViewClient()
        berita.loadUrl(web.toString())

        val webSettings = berita.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
    }
}