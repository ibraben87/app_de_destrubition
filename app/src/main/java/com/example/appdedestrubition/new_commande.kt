package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class new_commande : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<products>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var prix: Array<Double>
    lateinit var total: Array<Double>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_commande)
        imageId = arrayOf(
            R.drawable.cap,
            R.drawable.gari,
            R.drawable.skor,
            R.drawable.soum,
            R.drawable.tart,
            R.drawable.forex,


            )
        heading = arrayOf(
            "Caprrice",
            "Garido",
            "Skor",
            "Soummam",
            "Tartilla",
            "Forcexpres"
        )

        prix = arrayOf(
            10.00,12.00,15.00,14.00,17.00,16.00
        )
        total= arrayOf(
            10.00,12.00,15.00,14.00,17.00,16.00
        )



        newRecyclerView = findViewById(R.id.liste_produit)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<products>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val products = products(imageId[i], heading[i],prix[i],total[i])
            newArrayList.add(products)
        }
        newRecyclerView.adapter = MyAdaptor(newArrayList)
    }

}
