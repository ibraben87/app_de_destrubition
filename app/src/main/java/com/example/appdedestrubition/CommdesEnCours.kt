package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdapterCommandesEnCours
import com.example.appdedestrubition.addpters.AdapterConsulterCommande
import com.example.appdedestrubition.model.modelConsCommande
import java.sql.ResultSet

class CommdesEnCours : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commdes_en_cours)
        val con_commande: RecyclerView = findViewById(R.id.liste_commande_encours)
        val commandes = ArrayList<modelConsCommande>()

        val con = CrearConexionMySQL(this)

        val num_liv=intent.extras!!.getInt("num_livreur")

        val res: ResultSet? = con.cnx("SELECT * FROM `commande` WHERE `id_livreur` = $num_liv AND `versement` = 0")
        var etat=""

        do {
            res?.next()

            Toast.makeText(this,"${res!!.getInt("id_client")}", Toast.LENGTH_SHORT).show()


            val nom_client: ResultSet? = con.cnx("SELECT * FROM `client` WHERE `id_client` = ${res!!.getInt("id_client")}")

            nom_client!!.last()
            if (res.getString("etat_commande")==null)
            {
                etat=""
            }else{
                etat=res.getString("etat_commande")
            }
            val model = modelConsCommande(res.getInt("num_commande"), nom_client.getString("nom_client"), res.getDouble("total"),etat)

            commandes.add(model)

        } while (res?.isLast == false)

        con_commande.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        con_commande.adapter = AdapterCommandesEnCours(commandes)
    }
}