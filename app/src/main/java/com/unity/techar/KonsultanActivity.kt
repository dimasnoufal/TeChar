package com.unity.techar

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unity.techar.FirebaseMessageAdapter
import com.unity.techar.Message
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.unity.techar.databinding.ActivityChatBinding
import com.unity.techar.databinding.ActivityKonsultanBinding
import java.util.*

class KonsultanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKonsultanBinding
    private lateinit var auth: FirebaseAuth

    private lateinit var db: FirebaseDatabase
    private lateinit var adapter: FirebaseMessageAdapter

    //    private val requestNotificationPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ){
//            isGranted: Boolean ->
//        if (isGranted){
//            Toast.makeText(this, "Notifications permission granted", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Notifications permission rejected", Toast.LENGTH_SHORT).show()
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

//        if (Build.VERSION.SDK_INT >= 33) {
//            requestNotificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
//        }


        binding = ActivityKonsultanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        val firebaseUser = auth.currentUser
//        if (firebaseUser == null) {
//            // Not signed in, launch the Login activity
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//            return
//        }
        if (firebaseUser != null) {
            binding.tvName.text = firebaseUser.displayName
        } else {
            startActivity(Intent(this, LoginKonsultanActivity::class.java))
        }
        db = Firebase.database

        val messagesRef = db.reference.child(MESSAGES_CHILD)

        binding.img.setOnClickListener {
            startActivity(Intent(this, ProfileKonsultanActivity::class.java))
            finish()
        }

        binding.SendMessage.setOnClickListener {
            val friendlyMessage = Message(
                binding.etMessage.text.toString(),
                firebaseUser!!.displayName.toString(),
                Date().time
            )
            messagesRef.push().setValue(friendlyMessage) { error, _ ->
                if (error != null) {
                    Toast.makeText(this, getString(R.string.send_error) + error.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, getString(R.string.send_success), Toast.LENGTH_SHORT).show()
                }
            }
            binding.etMessage.setText("")
        }
        val manager = LinearLayoutManager(this)
        manager.stackFromEnd = true
        binding.chatRecyclerView.layoutManager = manager

        val options = FirebaseRecyclerOptions.Builder<Message>()
            .setQuery(messagesRef, Message::class.java)
            .build()
        adapter = FirebaseMessageAdapter(options, firebaseUser!!.displayName)
        binding.chatRecyclerView.adapter = adapter
    }

    public override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    public override fun onPause() {
        adapter.stopListening()
        super.onPause()
    }

    companion object {
        const val MESSAGES_CHILD = "messages"
    }
}