package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.model.modelCommandesEncours

class CommandesEnCours : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commandes_en_cours)
        val liste_commande_encours:RecyclerView=findViewById(R.id.listView_commades_attent)
        liste_commande_encours.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val liste_commande= ArrayList<modelCommandesEncours>()
        liste_commande.add(modelCommandesEncours(1,"client1",12.12))
        liste_commande.add(modelCommandesEncours(1,"client1",12.12))
        liste_commande.add(modelCommandesEncours(1,"client1",12.12))

    }
}