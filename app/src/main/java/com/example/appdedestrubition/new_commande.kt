package com.example.appdedestrubition

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class new_commande : AppCompatActivity() {
    /*private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<products>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var prix: Array<Double>
    lateinit var total: Array<Double>*/
    /* private var spinner: Spinner? = null*/
    lateinit var spinner: Spinner
    lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_commande)

        val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val currentDate = sdf.format(Date())
        val date_commande: EditText = findViewById(R.id.date_commande)
        val date = currentDate.toString()
        val con = CrearConexionMySQL(this)
        val idVendeur= intent.extras!!.getInt("idVendeur")
        date_commande.setText(date)
        spinner = findViewById(R.id.spinner_client) as Spinner
        val options = ArrayList<String>()
        options.add("Please Select an client")
        var nom_client: String? = null
        val resultSet = con.cnx("SELECT * FROM `client`")
        do {
            resultSet?.next()
            options.add(resultSet!!.getString("nom_client"))
        } while (resultSet!!.isLast == false)
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                nom_client = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.setText("Please Select an Option")

            }
        }
        val selct_produit: Button = findViewById(R.id.select_produit)
        selct_produit.setOnClickListener {
            var rse = con.cnx("SELECT * FROM `client` WHERE `nom_client` LIKE '$nom_client'")
            rse?.next()
            val  categorie= rse!!.getString("nom_categorie")
            con.extnoquery("INSERT INTO `commande` (`num_commande`, `date_commande`, `date_livre`, `etat_commande`, `total`, `id_client`, `id_vendeur`, `id_livreur`, `versement`) VALUES (NULL, '$date', '', NULL, '', '${rse.getInt("id_client")}', '$idVendeur', NULL, '');")
            rse=con.cnx("SELECT * FROM `commande` WHERE `date_commande` = '$date'")
            rse!!.next()
            val Intent_prd = Intent(this, select_products::class.java)
            Intent_prd.putExtra("num_commande", rse!!.getInt("num_commande"))
            Intent_prd.putExtra("categorie", categorie)
            startActivity(Intent_prd)
        }
    }
}
// val selct_produit :Button= findViewById(R.id.select_produit)
//
// selct_produit.setOnClickListener {
// val Intent_prd: Intent = Intent(this,select_products::class.java)
//
// startActivity(Intent_prd)
// }
//
//
// /*selct_produit.setOnClickListener {
// val rse: ResultSet? =con.cnx("SELECT * FROM `client` WHERE `nom_client` LIKE '${nom.text}'")
// rse?.next()
// con.extnoquery("INSERT INTO `commande` (`num_commande`, `date_commande`, `date_livre`, `total`, `id_client`) VALUES (NULL, '$date', '', '', '${rse?.getInt("id_client")}');")
//
// }*/
//
//
//
// /*imageId = arrayOf(
// R.drawable.cap,
// R.drawable.gari,
// R.drawable.skor,
// R.drawable.soum,
// R.drawable.tart,
// R.drawable.forex
//
//
// )
// heading = arrayOf(
// "Caprrice",
// "Garido",
// "Skor",
// "Soummam",
// "Tartilla",
// "Forcexpres"
// )
//
// prix = arrayOf(
// 10.00,12.00,15.00,14.00,17.00,16.00
// )
// total= arrayOf(
// 10.00,12.00,15.00,14.00,17.00,16.00
// )
//
//
//
// newRecyclerView = findViewById(R.id.liste_produit)
// newRecyclerView.layoutManager = LinearLayoutManager(this)
// newRecyclerView.setHasFixedSize(true)
// newArrayList = arrayListOf<products>()
// for (i in imageId.indices) {
// val products = products(imageId[i], heading[i],prix[i],total[i])
// newArrayList.add(products)
// }
// newRecyclerView.adapter = MyAdaptor(newArrayList)*/
// }
//
// /*private fun getUserdata() {
// for (i in imageId.indices) {
// val products = products(imageId[i], heading[i],prix[i],total[i])
// newArrayList.add(products)
// }
// newRecyclerView.adapter = MyAdaptor(newArrayList)
// }*/