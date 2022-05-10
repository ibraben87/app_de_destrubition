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
    }
}