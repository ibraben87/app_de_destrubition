package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdapterConsulterCommande
import com.example.appdedestrubition.model.modelConsCommande
import java.sql.ResultSet

class EnvoyerLesCommandes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_envoyer_les_commandes)
        Toast.makeText(this,"liste commandes", Toast.LENGTH_SHORT).show()

        val con_commande: RecyclerView =findViewById(R.id.liste_envouyer_commande)
        val commandes=ArrayList<modelConsCommande>()
        val con=CrearConexionMySQL(this)
        val res: ResultSet? = con.cnx("SELECT * FROM `commande`")
        do {
            res?.next()
            if (res!!.getDouble("total")!=0.0){
                val nom_client: ResultSet? =con.cnx("SELECT * FROM `client` WHERE `id_client` = ${res!!.getInt("id_client")}")
                nom_client!!.last()
                val model= modelConsCommande(res.getInt("num_commande"),nom_client.getString("nom_client"),res.getDouble("total") )
                commandes.add(model)
            }
        }while (res?.isLast == false)
        con_commande.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        con_commande.adapter= AdapterConsulterCommande(commandes)
    }
}