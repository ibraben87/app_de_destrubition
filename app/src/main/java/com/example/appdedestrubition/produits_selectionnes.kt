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


        val ajouterProduit: FloatingActionButton = findViewById(R.id.add_product)
        ajouterProduit.setOnClickListener {
            val ajouterPro = Intent(this, select_products::class.java)
            ajouterPro.putExtra("categorie",detail_client.getString("nom_categorie"))
            ajouterPro.putExtra("num_commande",numCommande)
            startActivity(ajouterPro)
        }
        val valide: FloatingActionButton = findViewById(R.id.valide)
        valide.setOnClickListener {
            Toast.makeText(this, "cv1", Toast.LENGTH_SHORT).show()

            var totale_commande = 0.0
            var i = 0
            while (i < liste_produit_commande.size) {
                totale_commande = totale_commande + liste_produit_commande[i].total
                i = i + 1
            }
            Toast.makeText(this, "cv2", Toast.LENGTH_SHORT).show()

            val builder = AlertDialog.Builder(this)
            Toast.makeText(this, "cv3", Toast.LENGTH_SHORT).show()

            with(builder) {
                setTitle("total:$totale_commande")
                setPositiveButton("ok") { dialog, wich ->
                    val Intent_consulter_commande: Intent =
                        Intent(builder.context, consulter_commandes::class.java)
                    startActivity(Intent_consulter_commande)
                    con.extnoquery("UPDATE `commande` SET `etat_commande` = 'en cour', `total` = '$totale_commande' WHERE `commande`.`num_commande` = $numCommande;")
                    val newCredit=detail_client.getDouble("credit")+totale_commande
                    con.extnoquery("UPDATE `client` SET `credit` = '$newCredit' WHERE `client`.`id_client` = ${detail_commande!!.getInt("id_client")};\n")

                }
                setNegativeButton("cancel") { dialog, wich ->
                }
                show()
            }
        }

    }

}