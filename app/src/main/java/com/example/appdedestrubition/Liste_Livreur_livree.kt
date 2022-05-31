package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdapterLivreur
import com.example.appdedestrubition.model.modelVenLiv
import java.sql.ResultSet

class Liste_Livreur_livree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_livreur_livree)
        val listeLivLivree:RecyclerView=findViewById(R.id.listView_liv_livree)
        val num= intent.extras?.getInt("numCommndeLivree")
        var res: ResultSet?=null
        val liv_ven=ArrayList<modelVenLiv>()
        res=CrearConexionMySQL(this).cnx("SELECT * FROM `livreur`")
        do {
            res!!.next()
            val ven_liv=modelVenLiv(res.getString("nom_livreur"),res.getString("mdp_livreur"),res.getString("login_livreur"),res.getString("prenom_livreur"))
            liv_ven.add(ven_liv)
        }while (res!!.isLast==false)
        listeLivLivree.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        listeLivLivree.adapter=AdapterLivreur(liv_ven,num)
    }
}