package com.example.projectui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sets actionbar title to Temp alert
        val actionBar = supportActionBar
        actionBar!!.title = "TempAlert"

        //Connects notification button
        var notificationBtn = findViewById<Button>(R.id.notiBtn)

        //Makes button clickable and creates an intent to go to the main activity2 page
        notificationBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
    }
}
