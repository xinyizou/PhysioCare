package com.example.hackthenorth2019_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rehab.setOnClickListener {
            goToRehabActivity()
        }

        chronic.setOnClickListener {
            goToChronicActivity()
        }

        chat.setOnClickListener {
            goToChatActivity()
        }
    }

    fun goToRehabActivity() {
        val intent = Intent(this, RehabActivity::class.java)
        startActivity(intent)
    }

    fun goToChronicActivity() {
        val intent = Intent(this, ChronicActivity::class.java)
        startActivity(intent)
    }

    fun goToChatActivity() {
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }

}
