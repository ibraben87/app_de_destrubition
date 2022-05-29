package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.sql.ResultSet

class Update_produit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_produit)
        val nomUpdate_produit:EditText=findViewById(R.id.update_nom_produit)
        val uniteUpdate_produit:EditText=findViewById(R.id.update_Unite_produit)
        val prixUpdate_produit1:EditText=findViewById(R.id.update_prix_categorie1)
        val prixUpdate_produit2:EditText=findViewById(R.id.update_prix_categorie2)
        val prixUpdate_produit3:EditText=findViewById(R.id.update_prix_categorie3)
        val nom_produit= intent?.extras?.getString("nom")
        val con=CrearConexionMySQL(this)
        val res:ResultSet?=con.cnx("SELECT * FROM `produit` WHERE `nom_produit` = '$nom_produit'")
        res?.first()
        val res_prirx1:ResultSet?=con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${res?.getInt("num_produit")} AND `nom_categorie` = 'categorie 1'")
        val res_prirx2:ResultSet?=con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${res?.getInt("num_produit")} AND `nom_categorie` = 'categorie 2'")
        val res_prirx3:ResultSet?=con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${res?.getInt("num_produit")} AND `nom_categorie` = 'categorie 3'")
        res_prirx1?.first()
        res_prirx2?.first()
        res_prirx3?.first()
        nomUpdate_produit.setText(res?.getString("nom_produit"))
        uniteUpdate_produit.setText(res?.getString("unite_carton"))
        prixUpdate_produit1.setText(res_prirx1?.getDouble("prix").toString())
        prixUpdate_produit2.setText(res_prirx2?.getDouble("prix").toString())
        prixUpdate_produit3.setText(res_prirx3?.getDouble("prix").toString())
        val update:Button=findViewById(R.id.update)
        update.setOnClickListener {
            con.extnoquery("UPDATE `contient` SET `prix` = '${prixUpdate_produit1.text}' WHERE `contient`.`num_produit` = ${res?.getInt("num_produit")} AND `contient`.`nom_categorie` = 'categorie 1';")
            con.extnoquery("UPDATE `contient` SET `prix` = '${prixUpdate_produit2.text}' WHERE `contient`.`num_produit` = ${res?.getInt("num_produit")} AND `contient`.`nom_categorie` = 'categorie 2';")
            con.extnoquery("UPDATE `contient` SET `prix` = '${prixUpdate_produit3.text}' WHERE `contient`.`num_produit` = ${res?.getInt("num_produit")} AND `contient`.`nom_categorie` = 'categorie 3';")
            con.extnoquery("UPDATE `produit` SET `nom_produit` = '${nomUpdate_produit.text}', `unite_carton` = '${uniteUpdate_produit.text}' WHERE `produit`.`num_produit` = ${res?.getInt("num_produit")};")
            val listDeProduits= Intent(this,List_de_produits::class.java)
            startActivity(listDeProduits)
        }
    }
}