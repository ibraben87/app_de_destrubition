package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.accept
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
        val list_client:Button=findViewById(R.id.liste_clients)
        list_client.setOnClickListener {
            val new = Intent(this, Liste_des_clients::class.java)
            startActivity(new)
        }
        val list_vendeur:Button=findViewById(R.id.liste_vendeur)
        list_vendeur.setOnClickListener {
            val IntentLivVen=Intent(this,List_vendeur_livreur::class.java)
            IntentLivVen.putExtra("type","vendeur")
            startActivity(IntentLivVen)
        }
        val list_livreur:Button=findViewById(R.id.liste_livreur)
        list_livreur.setOnClickListener {
            val IntentLivVen=Intent(this,List_vendeur_livreur::class.java)
            IntentLivVen.putExtra("type","livreur")
            startActivity(IntentLivVen)
        }
        val envoyer_commande:Button=findViewById(R.id.envoyer_commandes)
        envoyer_commande.setOnClickListener {
            val new = Intent(this, EnvoyerLesCommandes::class.java)
            startActivity(new)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.more ->{
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}