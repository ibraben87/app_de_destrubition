package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.ResultSet

class Ajouter_produit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajouter_produit)
        val nomProduit:EditText=findViewById(R.id.nom_produit)
        val uniteProduit:EditText=findViewById(R.id.Unite_produit)
        val PrixCategorie1:EditText=findViewById(R.id.prix_categorie1)
        val PrixCategorie2:EditText=findViewById(R.id.prix_categorie2)
        val PrixCategorie3:EditText=findViewById(R.id.prix_categorie3)
        val submit:Button=findViewById(R.id.submit_produit)
        val con=CrearConexionMySQL(this)
        submit.setOnClickListener {
            if ((uniteProduit.text.toString()=="" || nomProduit.text.toString()=="" || PrixCategorie1.text.toString()=="" || PrixCategorie2.text.toString()=="" || PrixCategorie3.text.toString()=="")){
                Toast.makeText(this,"rempli tout les case svp",Toast.LENGTH_SHORT).show()
            }else{
            con.extnoquery("INSERT INTO `produit` (`num_produit`, `nom_produit`, `photo_produit`, `unite_carton`, `id_societe`) VALUES (NULL, '${nomProduit.text.toString()}', '', '${uniteProduit.text.toString()}', '1');\n")
            val res: ResultSet? =CrearConexionMySQL(this).cnx("SELECT `num_produit` FROM `produit` WHERE `nom_produit` = '${nomProduit.text.toString()}'")
            res?.last()
            val idPRo=res?.getInt("num_produit")
            con.extnoquery("INSERT INTO `contient` (`num_produit`, `nom_categorie`, `prix`) VALUES ('$idPRo', 'categorie 1', '${PrixCategorie1.text.toString()}');")
            con.extnoquery("INSERT INTO `contient` (`num_produit`, `nom_categorie`, `prix`) VALUES ('$idPRo', 'categorie 2', '${PrixCategorie2.text.toString()}');")
            con.extnoquery("INSERT INTO `contient` (`num_produit`, `nom_categorie`, `prix`) VALUES ('$idPRo', 'categorie 3', '${PrixCategorie3.text.toString()}');")
            val retour:Intent=Intent(this,List_de_produits::class.java)
            startActivity(retour)}

        }
    }
}