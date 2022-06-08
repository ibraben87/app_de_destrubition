package com.example.appdedestrubition.addpters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.Liste_Livreur_livree
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelConsCommande

class AdapterEnvoyerCommandes(val commande:ArrayList<modelConsCommande>): RecyclerView.Adapter<AdapterEnvoyerCommandes.ViewHolder>() {
    class ViewHolder(itemView: View, var commande: modelConsCommande?=null) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val Intent_liv=Intent(itemView.context,Liste_Livreur_livree::class.java)
                Intent_liv.putExtra("numCommndeLivree", commande!!.num_commande)
                itemView.context.startActivity(Intent_liv)
            }
        }
    val numCom=itemView.findViewById<TextView>(R.id.num_commande1)
    val nomClient=itemView.findViewById<TextView>(R.id.nom_client1)
    val total1=itemView.findViewById<TextView>(R.id.total_comande1)
        val etat=itemView.findViewById<TextView>(R.id.etat_commande)


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
        holder.etat.text=data.etat_commade
        holder.commande=data
    }
}