package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Vendeur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendeur)
        val btn_new_comande  =findViewById<Button>(R.id.new_comande)
        btn_new_comande.setOnClickListener {
            val intent_new_comande:Intent= Intent(this,new_commande::class.java)
            startActivity(intent_new_comande)
        }
    }
}