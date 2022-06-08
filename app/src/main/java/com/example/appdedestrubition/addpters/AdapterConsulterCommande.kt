package com.example.appdedestrubition.addpters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.Update_produit
import com.example.appdedestrubition.model.modelConsCommande
import com.example.appdedestrubition.model.modelProduit
import com.example.appdedestrubition.produits_selectionnes

class AdapterConsulterCommande (commandes:ArrayList<modelConsCommande>
): RecyclerView.Adapter<AdapterConsulterCommande.ViewHolder>() {
    val commandes=commandes
    class ViewHolder(itemView: View,var com_selc:modelConsCommande?=null): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val Intent_commande=Intent(itemView.context, produits_selectionnes::class.java)
                Intent_commande.putExtra("numerota3lacommande", com_selc!!.num_commande)
                itemView.context.startActivity(Intent_commande)
            }
        }

        val numCom=itemView.findViewById<TextView>(R.id.num_commande1)
        val nomClient=itemView.findViewById<TextView>(R.id.nom_client1)
        val total1=itemView.findViewById<TextView>(R.id.total_comande1)
        val etat=itemView.findViewById<TextView>(R.id.etat_commande)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterConsulterCommande.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.item_commande,parent,false)
        return AdapterConsulterCommande.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return commandes.size
    }

    override fun onBindViewHolder(holder: AdapterConsulterCommande.ViewHolder, position: Int) {
        val data:modelConsCommande=commandes[position]
        holder.nomClient.text= data.nom_client
        holder.numCom.text=data.num_commande.toString()
        holder.total1.text=data.total.toString()
        holder.etat.text=data.etat_commade
        holder.com_selc=data
    }
}