package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity_Livreur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_livreur)
        val commandeEnCours:Button=findViewById(R.id.Commandes)
        val numLiv= intent.extras!!.getInt("numLiv")

        val commandeDistribuees:Button=findViewById(R.id.Commandes_en_attente)
        commandeDistribuees.setOnClickListener {
            val IntentCommandesEnCours=Intent(this,CommandesDistribuees::class.java)
            IntentCommandesEnCours.putExtra("num_livreur_detr",numLiv)
            startActivity(IntentCommandesEnCours)
        }
        val nos_client:Button=findViewById(R.id.Nos_clients)
        nos_client.setOnClickListener {
            val new = Intent(this, Liste_des_clients::class.java)
            startActivity(new)
        }
        commandeEnCours.setOnClickListener {
            val IntentCommandesEnCours=Intent(this,CommdesEnCours::class.java)
            IntentCommandesEnCours.putExtra("num_livreur",numLiv)
            startActivity(IntentCommandesEnCours)
        }
    }
}