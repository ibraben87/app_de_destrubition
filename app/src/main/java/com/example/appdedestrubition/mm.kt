package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner
import android.os.Bundle
import android.view.View
import com.example.appdedestrubition.R

class mm : AppCompatActivity() {
    private var spinner: Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        User.initUsers()
        spinner = findViewById<View>(R.id.spinner_client) as Spinner
        val customAdapter =
            SpinnerAdapter(this, R.layout.activity_spinner_client, User.userArrayList)
        spinner!!.adapter = customAdapter
    }
}