package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class produits_selectionnes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits_selectionnes)
        val ajouterProduit: FloatingActionButton =findViewById(R.id.add_product)
        ajouterProduit.setOnClickListener {
            val ajouterPro: Intent = Intent(this,select_products::class.java)
            startActivity(ajouterPro)
        }
    }

}