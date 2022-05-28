package com.example.appdedestrubition

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

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

        setContentView(R.layout.activity_new_commande)
        val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        Toast.makeText(this, currentDate.toString(), Toast.LENGTH_SHORT).show()
        val nom: EditText = findViewById(R.id.nom_client_commande)
        val date_commande: EditText = findViewById(R.id.date_commande)
        val date = currentDate.toString()
        val con = CrearConexionMySQL(this)
        date_commande.setText(date)
        date.replace("/", "-", false)
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_client)

        /*User.initUsers()*/
        spinner = findViewById(R.id.spinner_client) as Spinner
        result = findViewById(R.id.nom_client_commande) as TextView
        val options = arrayOf("opt1", "opt2", "opt3")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result.text = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = "Please Select an Option"

            }
        }


        val customAdapter =
            SpinnerAdapter(this, R.layout.activity_spinner_client, User.userArrayList)
        spinner!!.adapter = customAdapter


    }}
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