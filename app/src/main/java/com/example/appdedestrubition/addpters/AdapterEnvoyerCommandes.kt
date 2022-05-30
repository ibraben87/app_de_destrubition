package com.example.appdedestrubition.addpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelConsCommande

class AdapterEnvoyerCommandes(val commande:ArrayList<modelConsCommande>): RecyclerView.Adapter<AdapterEnvoyerCommandes.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val numCom=itemView.findViewById<TextView>(R.id.num_commande1)
    val nomClient=itemView.findViewById<TextView>(R.id.nom_client1)
    val total1=itemView.findViewById<TextView>(R.id.total_comande1)
}
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v= LayoutInflater.from(parent.context).inflate(R.layout.item_commande,parent,false)
    return ViewHolder(v)
}

override fun getItemCount(): Int {
    return commande.size
}
    

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: modelConsCommande =commande[position]
        holder.nomClient.text= data.nom_client
        holder.numCom.text=data.num_commande.toString()
        holder.total1.text=data.total.toString()
    }
}