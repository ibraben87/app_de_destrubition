package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity_Livreur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_livreur)

        val Commandes_en_cours:Button=findViewById(R.id.Commandes)
        Commandes_en_cours.setOnClickListener {
            val Intent_Commandes_en_cours= Intent(this,CommandesEnCours::class.java)
            startActivity(Intent_Commandes_en_cours)
        }
        val Commandes_distribuées:Button=findViewById(R.id.Commandes_en_attente)
        Commandes_distribuées.setOnClickListener {
            val Intent_Commandes_distribuées= Intent(this,Commandes_distribuées::class.java)
            startActivity(Intent_Commandes_distribuées)
        }
        val Liste_clients:Button=findViewById(R.id.Nos_clients)
        Liste_clients.setOnClickListener {
            val Intent_liste_clients= Intent(this,Liste_clients::class.java)
            startActivity(Intent_liste_clients)
        }

    }
}