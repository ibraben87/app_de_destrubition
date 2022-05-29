package com.example.appdedestrubition.addpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelClient

class AdappterListeClients(val clients:ArrayList<modelClient>): RecyclerView.Adapter<AdappterListeClients.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id_client:TextView=itemView.findViewById(R.id.id_client)
        val nom_client:TextView=itemView.findViewById(R.id.item_nom_client)
        val num_client:TextView=itemView.findViewById(R.id.num_client)
        val localisation_client:TextView=itemView.findViewById(R.id.localisation_client)
        val credit_client:TextView=itemView.findViewById(R.id.credit)
    }

    override fun getItemCount(): Int {
        return clients.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id_client.text=clients[position].id_client.toString()
        holder.nom_client.text=clients[position].nom_client
        holder.num_client.text=clients[position].num_client
        holder.localisation_client.text=clients[position].localisation_client
        holder.credit_client.text=clients[position].credit_client.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateLayout=LayoutInflater.from(parent.context).inflate(R.layout.item_client,parent,false)
        return ViewHolder(inflateLayout)
    }


}