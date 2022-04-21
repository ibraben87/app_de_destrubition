package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_livreur:Button=findViewById(R.id.livreur)
        btn_livreur.setOnClickListener {
            val Intent_login:Intent=Intent(login:cla)
        }
    }
}