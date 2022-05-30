package com.example.appdedestrubition.addpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelCommandesEncours

class AddapterCommandesEncours(val commandesEncours: ArrayList<modelCommandesEncours>): RecyclerView.Adapter<AddapterCommandesEncours.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numCam:TextView=itemView.findViewById(R.id.num_commande1)
        val nomCli:TextView=itemView.findViewById(R.id.nom_client1)
        val total:TextView=itemView.findViewById(R.id.total_comande1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.item_commande,parent,false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data=commandesEncours[position]
        holder.numCam.text=data.num_commande.toString()
        holder.nomCli.text=data.nom_client.toString()
        holder.total.text=data.total_commande.toString()
    }

    override fun getItemCount(): Int {
        return commandesEncours.size
    }
}