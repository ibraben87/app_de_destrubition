package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AddapterProduitsSlectionne
import com.example.appdedestrubition.model.modelItemCommande
import com.google.android.material.floatingactionbutton.FloatingActionButton

class produits_selectionnes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits_selectionnes)
        val produits_selcte: RecyclerView = findViewById(R.id.produit_commande)
        produits_selcte.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val numCommande = intent.extras?.getInt("numerota3lacommande")
        val con: CrearConexionMySQL = CrearConexionMySQL(this)
        val detail_commande =
            con.cnx("SELECT * FROM `commande` WHERE `num_commande` = $numCommande")
        detail_commande?.next()
        val detail_client =
            con.cnx("SELECT * FROM `client` WHERE `id_client` = ${detail_commande!!.getInt("id_client")}")
        detail_client!!.next()
        val produit_commande =
            con.cnx("SELECT * FROM `commander` WHERE `num_commande` = $numCommande")

        val liste_produit_commande = ArrayList<modelItemCommande>()
        do {
            produit_commande?.next()
            val infoProduit =
                con.cnx("SELECT * FROM `produit` WHERE `num_produit` = ${produit_commande?.getInt("num_produit")}")
            infoProduit!!.next()
            val prix =
                con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${infoProduit!!.getInt("num_produit")} AND `nom_categorie` = '${
                    detail_client.getString("nom_categorie")
                }'")
            prix!!.next()
            val model = modelItemCommande(produit_commande!!.getDouble("quantite`"),
                infoProduit.getString("nom_produit"),
                prix.getDouble("prix"),
                produit_commande.getDouble("quantite`") * prix.getDouble("prix") * infoProduit.getInt(
                    "unite_carton"),
                infoProduit.getInt("unite_carton"))
            liste_produit_commande.add(model)
        } while (produit_commande!!.isLast == false)
        produits_selcte.adapter = AddapterProduitsSlectionne(liste_produit_commande)


        val ajouterProduit: FloatingActionButton = findViewById(R.id.add_product)
        ajouterProduit.setOnClickListener {
            val ajouterPro = Intent(this, select_products::class.java)
            startActivity(ajouterPro)
        }
        val valide: FloatingActionButton = findViewById(R.id.valide)
        valide.setOnClickListener {
            var totale_commande = 0.0
            for (i in 0..liste_produit_commande.size) {
                totale_commande = +liste_produit_commande[i].total
            }
            con.extnoquery("UPDATE `commande` SET `total` = '$totale_commande' WHERE `commande`.`num_commande` = $numCommande;")

        }

    }

}