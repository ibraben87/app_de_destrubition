package com.example.appdedestrubition.addpters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelProduit

class AdappterListProduits(produits:ArrayList<modelProduit>
): RecyclerView.Adapter<AdappterListProduits.ViewHolder>() {
    val Produits=produits
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"rana metfahmin",Toast.LENGTH_SHORT).show()

            }
        }

        val nomProduit=itemView.findViewById<TextView>(R.id.item_nom_produit)
        val imageProdui=itemView.findViewById<ImageView>(R.id.item_image_produit)
        val uniteProduit=itemView.findViewById<TextView>(R.id.item_unite_produit)
        val prixProduit=itemView.findViewById<TextView>(R.id.item_prix_produit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.item_produit,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Produits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data:modelProduit=Produits[position]
        holder.nomProduit.text= data.nom_produi
        holder.imageProdui.setImageResource(data.image_produit)
        holder.uniteProduit.text=data.unite.toString()
        holder.prixProduit.text=data.prix.toString()
    }
}