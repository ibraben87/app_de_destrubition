package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdappterListProduits
import com.example.appdedestrubition.model.modelProduit
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.ResultSet




class List_de_produits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_de_produits)
        Toast.makeText(this,"liste produit",Toast.LENGTH_SHORT).show()

        val ListView_produit:RecyclerView=findViewById(R.id.listView_produit)
        val produits=ArrayList<modelProduit>()
        val con=CrearConexionMySQL(this)
        val res: ResultSet? = con.cnx("SELECT * FROM `produit`")
        do {
            res?.next()
            val prix_cat: ResultSet? =con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${res!!.getInt("num_produit")} AND `nom_categorie` = 'categorie 3'")
            prix_cat!!.last()
            var prix:Double=0.000
            prix=prix_cat.getDouble("prix")
            val pro= modelProduit(res!!.getString("nom_produit"),R.drawable.bien_remplir_une_fiche_produit,res.getInt("unite_carton"),prix)
            produits.add(pro)
        }while (res?.isLast == false)
        produits.add(modelProduit("produit1",R.drawable.bien_remplir_une_fiche_produit,48, 15.0))
        produits.add(modelProduit("produit2",R.drawable.bien_remplir_une_fiche_produit,48, 16.0))
        produits.add(modelProduit("produit3",R.drawable.bien_remplir_une_fiche_produit,48, 17.0))
        ListView_produit.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        ListView_produit.adapter=AdappterListProduits(produits)
        val ajouterProduit:FloatingActionButton=findViewById(R.id.ajouter_prodtuit)
        ajouterProduit.setOnClickListener {
            val ajouterPro:Intent=Intent(this,Ajouter_produit::class.java)
            startActivity(ajouterPro)
        }
    }
}

