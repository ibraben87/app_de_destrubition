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
        val btn_vendeur:Button=findViewById(R.id.vendeur)
        val btn_societe:Button=findViewById(R.id.societe)
        btn_livreur.setOnClickListener {
            val Intent_login:Intent=Intent(this,login::class.java)
            Intent_login.putExtra("user","livreur")
            startActivity(Intent_login)
        }
        btn_vendeur.setOnClickListener {
            val Intent_login:Intent=Intent(this,login::class.java)
            Intent_login.putExtra("user","vendeur")
            startActivity(Intent_login)
        }
        btn_societe.setOnClickListener {
            val Intent_login:Intent=Intent(this,login::class.java)
            Intent_login.putExtra("user","societe")
            startActivity(Intent_login)
        }

    }
}