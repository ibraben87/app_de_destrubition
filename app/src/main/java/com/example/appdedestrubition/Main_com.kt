package com.example.appdedestrubition



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import androidx.core.content.ContextCompat.startActivity
import com.example.appdedestrubition.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdedestrubition.addpters.AdappterListProduits
import com.example.appdedestrubition.model.modelProduit
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.ResultSet
import java.util.ArrayList
import com.example.appdedestrubition.new_commande as new_commande1

class Main_com  : AppCompatActivity() {
    var sourcelist: MutableList<String>? = null
    var selectedlist: List<String>? = null
    private var mRecyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var madapter: Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val produits=ArrayList<modelCommande>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sourcelist = ArrayList()
        sourcelist.add("Object 1")
        sourcelist.add("Object 2")
        sourcelist.add("Object 3")
        sourcelist.add("Object 4")
        (sourcelist as ArrayList<String>).add("Object 5")
        sourcelist.add("Object 6")
        sourcelist.add("Object 7")
        sourcelist.add("Object 8")
        mRecyclerView = findViewById(R.id.recyclerView)
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.setLayoutManager(mLayoutManager)
        madapter = Adapter(sourcelist, applicationContext, mRecyclerView)
        mRecyclerView.setAdapter(madapter)
    }

    fun getData(V: View?) {
        selectedlist = madapter.list()
        Log.d("list", selectedlist.toString())
    }
}
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_de_produits)
    val ListView_commande:RecyclerView=findViewById(R.id.listView_commande)
    val produits=ArrayList<modelProduit>()
    val con=CrearConexionMySQL(this)
    val res: ResultSet? = con.cnx("SELECT * FROM `commande`")
    do {
        res?.next()
        val prix_cat: ResultSet? =con.cnx("SELECT * FROM ")
        prix_cat!!.last()

        val pro= modelcom(res!!.getString("nom_commande"))
        produits.add(pro)
    }while (res?.isLast == false)

    ListView_commande.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    ListView_commande.adapter= AdappterListProduits(produits)
    val ajouterProduit: FloatingActionButton =findViewById(R.id.new_comande)
    ajouterProduit.setOnClickListener {
        val ajouterPro: Intent = Intent(this,Ajouter_produit::class.java)
        startActivity(new_commande)
    }
}
}
