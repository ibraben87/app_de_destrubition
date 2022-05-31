package com.example.appdedestrubition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AddapterLivVen
import com.example.appdedestrubition.model.modelVenLiv
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.ResultSet

class List_vendeur_livreur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vendeur_livreur)
        val listVendeurLivreur:RecyclerView=findViewById(R.id.listView_ven_liv)
        val type= intent.extras?.getString("type")
        var res:ResultSet?=null
        val liv_ven=ArrayList<modelVenLiv>()
        if (type=="vendeur"){
            res=CrearConexionMySQL(this).cnx("SELECT * FROM `vendeur`")
            do {
                res!!.next()
                val ven_liv=modelVenLiv(res.getString("nom_vendeur"),res.getString("mdp_vendeur"),res.getString("login_vendeur"),res.getString("prenom_vendeur"))
                liv_ven.add(ven_liv)

            }while (res!!.isLast==false)
        }else if (type=="livreur"){
            res=CrearConexionMySQL(this).cnx("SELECT * FROM `livreur`")
            do {
                res!!.next()
                val ven_liv=modelVenLiv(res.getString("nom_livreur"),res.getString("mdp_livreur"),res.getString("login_livreur"),res.getString("prenom_livreur"))
                liv_ven.add(ven_liv)
            }while (res!!.isLast==false)
        }else{
            Toast.makeText(this,"il ya un problem",Toast.LENGTH_LONG).show()
        }
        listVendeurLivreur.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        listVendeurLivreur.adapter=AddapterLivVen(liv_ven)
        val ajout_acount:FloatingActionButton=findViewById(R.id.ajouter_acount)
        ajout_acount.setOnClickListener{
            val new_acount=Intent(this,new_acount::class.java)
            startActivity(new_acount)
        }
    }
}