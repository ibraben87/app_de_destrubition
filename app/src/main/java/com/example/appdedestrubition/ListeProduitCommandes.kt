package com.example.appdedestrubition

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AddapterProduitsSlectionne
import com.example.appdedestrubition.model.modelItemCommande
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ListeProduitCommandes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_produit_commandes)
        val produits_selcte: RecyclerView = findViewById(R.id.liste_produit_commande)
        produits_selcte.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val numCommande = intent.extras?.getInt("numcommandeLivreur")
        val con = CrearConexionMySQL(this)
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
                con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${infoProduit!!.getInt("num_produit")} AND `nom_categorie` = '${detail_client.getString("nom_categorie")}'")
            prix!!.next()
            val model = modelItemCommande(produit_commande!!.getDouble("quantite`"),
                infoProduit.getString("nom_produit"),
                prix.getDouble("prix"),
                produit_commande.getDouble("quantite`") * prix.getDouble("prix") * infoProduit.getInt("unite_carton"),
                infoProduit.getInt("unite_carton"))
            liste_produit_commande.add(model)
        } while (produit_commande!!.isLast == false)
        produits_selcte.adapter = AddapterProduitsSlectionne(liste_produit_commande)

        val valide: FloatingActionButton = findViewById(R.id.valide_versement)
        valide.setOnClickListener {

            var totale_commande = 0.0
            var i = 0
            while (i < liste_produit_commande.size) {
                totale_commande = totale_commande + liste_produit_commande[i].total
                i = i + 1
            }

            val builder = AlertDialog.Builder(this)
            val Inflater: LayoutInflater = LayoutInflater.from(this)
            val dialogLayout = Inflater.inflate(R.layout.versement, null)
            val Versemnt = dialogLayout.findViewById<EditText>(R.id.versement_commandes)
            var versement: String? = null
            with(builder) {
                setTitle("enter versement")
                setMessage("total commande : $totale_commande")
                setPositiveButton("ok") { dialog, wich ->
                    versement = Versemnt.text.toString()
                    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                    val currentDate = sdf.format(Date())
                    val date=currentDate.toString()
                    val con = CrearConexionMySQL(this@ListeProduitCommandes)
                    con.extnoquery("UPDATE `commande` SET `date_livre` = '$date', `etat_commande` = 'destribue', `versement` = '$versement' WHERE `commande`.`num_commande` = $numCommande;")
                    val newCredit=detail_client.getDouble("credit")- versement!!.toDouble()
                    con.extnoquery("UPDATE `client` SET `credit` = '$newCredit' WHERE `client`.`id_client` = ${detail_commande!!.getInt("id_client")};")

                }
                setNegativeButton("cancel") { dialog, wich ->
                }
                setView(dialogLayout)
                show()
            }
            Toast.makeText(this, "cv4", Toast.LENGTH_SHORT).show()
    }
}}