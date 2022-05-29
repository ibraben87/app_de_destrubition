package com.example.appdedestrubition.addpters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.Update_produit
import com.example.appdedestrubition.model.modelItemCommande
import com.example.appdedestrubition.model.modelProduit

class AddapterProduitsSlectionne (produits:ArrayList<modelItemCommande>): RecyclerView.Adapter<AddapterProduitsSlectionne.ViewHolder>() {
    val Produits=produits
    class ViewHolder(itemView: View, var produit_selc: modelItemCommande?=null): RecyclerView.ViewHolder(itemView) {

        val nomProduit=itemView.findViewById<TextView>(R.id.nom_produit)
        val qte=itemView.findViewById<TextView>(R.id.qte_prodect)
        val prix=itemView.findViewById<TextView>(R.id.prix)
        val total=itemView.findViewById<TextView>(R.id.total)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.item_prodect,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Produits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: modelItemCommande =Produits[position]
        holder.nomProduit.text= data.nom_produit
        holder.qte.text="${data.qte}*${data.unite}"
        holder.prix.text=data.prix.toString()
        holder.total.text=data.total.toString()
        holder.produit_selc=data
    }
}