package com.example.projectui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //add a actionbar method to display users curren5t screen
        val actionBar = supportActionBar

        //Set action bar title to "notification setup" for current screen
        actionBar!!.title = "Notification setup"

        actionBar.setDisplayHomeAsUpEnabled(true)


       // var radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup)

     // set onChecked radio listener

    }}