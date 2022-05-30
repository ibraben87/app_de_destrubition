package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdappterListProduits
import com.example.appdedestrubition.addpters.AdapterConsulterCommande
import com.example.appdedestrubition.model.modelConsCommande
import com.example.appdedestrubition.model.modelProduit
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.ResultSet

class consulter_commandes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulter_commandes)
       /* val nom: EditText =findViewById(R.id.nom_client1)
        val num: EditText =findViewById(R.id.num_commande1)
        val total: EditText =findViewById(R.id.total_comande1)*/



        Toast.makeText(this,"liste commandes",Toast.LENGTH_SHORT).show()

        val con_commande: RecyclerView =findViewById(R.id.con_commmande)
        val commandes=ArrayList<modelConsCommande>()
        val con=CrearConexionMySQL(this)
        val res: ResultSet? = con.cnx("SELECT * FROM `commande`")
        do {
            res?.next()
            val prix_cat: ResultSet? =con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${res!!.getInt("num_produit")} AND `nom_categorie` = 'categorie 3'")
            prix_cat!!.last()
            var prix:Double=0.000
            prix=prix_cat.getDouble("prix")
            val pro= modelProduit(res!!.getString("nom_produit"),R.drawable.bien_remplir_une_fiche_produit,res.getInt("unite_carton"),prix)
            commandes.add(pro)
        }while (res?.isLast == false)
        commandes.add(modelConsCommande("com1",R.drawable.bien_remplir_une_fiche_produit,48, 15.0))
       commandes.add(modelConsCommande("com2",R.drawable.bien_remplir_une_fiche_produit,48, 16.0))
        commandes.add(modelConsCommande("com3",R.drawable.bien_remplir_une_fiche_produit,48, 17.0))
        con_commande.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        con_commande.adapter= AdapterConsulterCommande(commandes)

    }
}