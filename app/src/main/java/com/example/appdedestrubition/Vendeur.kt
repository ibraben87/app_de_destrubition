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
        val idven= intent.extras!!.getInt("id_vendeur")
        btn_new_comande.setOnClickListener {
            val intent_new_comande= Intent(this,new_commande::class.java)
            intent_new_comande.putExtra("idVendeur",idven)
            startActivity(intent_new_comande)
        }
        val btn_new_client  =findViewById<Button>(R.id.new_client)
        btn_new_client.setOnClickListener {
            val intent_new_client= Intent(this,new_client::class.java)
            startActivity(intent_new_client)
        }


        val btn_list_client:Button=findViewById(R.id.btn_liste_client)
        val btn_list_pro:Button=findViewById(R.id.btn_liste_pro)
        val btn_consult_com:Button=findViewById(R.id.btn_cosult_com)
        btn_list_client.setOnClickListener {
            val Intent_client:Intent=Intent(this,Liste_des_clients::class.java)
            startActivity(Intent_client)
        }
        btn_list_pro.setOnClickListener {
            val Intent_pro:Intent=Intent(this,List_de_produits::class.java)
            startActivity(Intent_pro)
        }
        btn_consult_com.setOnClickListener {
            val Intent_consult:Intent=Intent(this,consulter_commandes::class.java)
            startActivity(Intent_consult)
        }







    }
}

