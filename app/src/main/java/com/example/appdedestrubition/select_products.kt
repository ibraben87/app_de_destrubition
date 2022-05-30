package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdappterSelectPr
import com.example.appdedestrubition.model.modelProduit
import java.sql.ResultSet




class select_products : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_products)
        val ListView_produit:RecyclerView=findViewById(R.id.listView_produit)
        val num_commande= intent.extras?.getInt("num_commande")
        Toast.makeText(this,"num$num_commande",Toast.LENGTH_LONG).show()
        val categorie= intent.extras?.getString("categorie")
        val produits=ArrayList<modelProduit>()
        val con=CrearConexionMySQL(this)
        val res: ResultSet? = con.cnx("SELECT * FROM `produit`")
        do {
            res?.next()
            val prix_catt: ResultSet? =con.cnx("SELECT * FROM `contient` WHERE `num_produit` = ${res!!.getInt("num_produit")} AND `nom_categorie` = '$categorie'")
            prix_catt!!.last()
            if(prix_catt.row!=0){
            var prix:Double=0.000
            prix=prix_catt.getDouble("prix")
            val pro= modelProduit(res!!.getString("nom_produit"),R.drawable.bien_remplir_une_fiche_produit,res.getInt("unite_carton"),prix)
            produits.add(pro)}
        }while (res?.isLast == false)
        ListView_produit.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        ListView_produit.adapter=AdappterSelectPr(produits,num_commande)
    }
}
