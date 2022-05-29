package com.example.appdedestrubition

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.model.modelProduit
import java.sql.ResultSet
import java.util.ArrayList

class User(var id: String, var name: String) {
    /* val image: Int
         get() {
             when (id) {
                 "0" -> return R.drawable.usericon0
                 "1" -> return R.drawable.usericon1
                 "2" -> return R.drawable.usericon2
                 "3" -> return R.drawable.usericon3
                 "4" -> return R.drawable.usericon4
                 "5" -> return R.drawable.usericon5
             }
             return R.drawable.usericon0
         }*/

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_client)
        val ListSpinnerClient: RecyclerView = findViewById(R.id.list_spinner_client)
        val client =ArrayList<modelProduit>()
        val con=CrearConexionMySQL(this)
        val res: ResultSet? = con.cnx("SELECT * FROM `produit`")
        do {
            res?.next()
            val client: ResultSet? =con.cnx("INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `credit`, `localisation`, `Num`, `nom_categorie`) VALUES (NULL, '${nom.text}', '${prenom.text}', '${credit.text}', '${localisation.text}', '${phone.text}', '${categorie.text}');")

            var prix:Double=0.000
            prix=prix_cat.getDouble("prix")
            val pro= modelProduit(res!!.getString("nom_produit"),R.drawable.bien_remplir_une_fiche_produit,res.getInt("unite_carton"),prix)
            produits.add(pro)
        }while (res?.isLast == false)*/




    companion object {
        val userArrayList = ArrayList<User>()
        fun initUsers() {
            val user1 = User("0", "Cal")
            userArrayList.add(user1)
            val user2 = User("1", "John")
            userArrayList.add(user2)
            val user3 = User("2", "Mary")
            userArrayList.add(user3)
            val user4 = User("3", "Satoshi")
            userArrayList.add(user4)
            val user5 = User("4", "Maria")
            userArrayList.add(user5)
            val user6 = User("5", "Sam")
            userArrayList.add(user6)
        }
    }
}