package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.intellij.lang.annotations.Language
import java.sql.Connection
import java.sql.DriverManager

class societe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_societe)
        val consulter_commande:Button=findViewById(R.id.cosulter_commande)
        consulter_commande.setOnClickListener {
            val Intent_commande:Intent= Intent(this,consulter_commandes::class.java)
            startActivity(Intent_commande)
        }
        val newacount:Button=findViewById(R.id.new_acount)
        newacount.setOnClickListener {
            val new = Intent(this, new_acount::class.java)
            startActivity(new)
        }
        val list_produit:Button=findViewById(R.id.liste_produit)
        list_produit.setOnClickListener {
            val new = Intent(this, List_de_produits::class.java)
            startActivity(new)
        }
    }
}