package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.addpters.AdappterListeClients
import com.example.appdedestrubition.model.modelClient

class Liste_des_clients : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_des_clients)
        val client_list:RecyclerView=findViewById(R.id.listView_client)
        client_list.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val con=CrearConexionMySQL(this)
        val res=con.cnx("SELECT * FROM `client`")
        val clients=ArrayList<modelClient>()
        do {
            res?.next()
            val client=modelClient(res?.getString("nom_client"), res?.getInt("id_client"),res?.getString("Num"),res?.getDouble("credit"),res?.getString("localisation"))
            clients.add(client)
        }while (res?.isLast == false)
        client_list.adapter=AdappterListeClients(clients)
    }
}