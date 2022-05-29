package com.example.appdedestrubition.addpters

import android.app.AlertDialog
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.CrearConexionMySQL
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelProduit
import com.example.appdedestrubition.produits_selectionnes
import java.util.zip.Inflater
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast

class AdappterSelectPr(
    produits: ArrayList<modelProduit>,numCommande: Int?
) : RecyclerView.Adapter<AdappterSelectPr.ViewHolder>() {


    val Produits = produits
    val num_commande=numCommande

    class ViewHolder(itemView: View, var produits: modelProduit? =null,var numCommande: Int?=null) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val builder=AlertDialog.Builder(itemView.context)
                val Inflater: LayoutInflater = LayoutInflater.from(itemView.context)
                val dialogLayout=Inflater.inflate(R.layout.qte,null)
                val qte=dialogLayout.findViewById<EditText>(R.id.qte)
                var qQte:String?=null
                with(builder){
                    setTitle("entrer la quantite")
                    setPositiveButton("ok"){dialog,wich->
                        qQte=qte.text.toString()
                        val con=CrearConexionMySQL(itemView.context)
                        val result=con.cnx("SELECT * FROM `produit` WHERE `nom_produit` = '${produits?.nom_produi}'")
                        result!!.next()
                        con.extnoquery("INSERT INTO `commander` (`num_commande`, `num_produit`, `quantite```) VALUES ('$numCommande', '${result.getInt("num_produit")}', '$qQte');")
                        val Intent_commande=Intent(itemView.context,produits_selectionnes::class.java)
                        Intent_commande.putExtra("numerota3lacommande",numCommande)
                        itemView.context.startActivity(Intent_commande)
                    }
                    setNegativeButton("cancel"){dialog,wich->

                    }
                    setView(dialogLayout)
                    show()
                }
            }
        }

        val nomProduit = itemView.findViewById<TextView>(R.id.item_nom_produit)
        val uniteProduit = itemView.findViewById<TextView>(R.id.item_unite_produit)
        val prixProduit = itemView.findViewById<TextView>(R.id.item_prix_produit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_produit, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Produits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: modelProduit = Produits[position]
        holder.nomProduit.text = data.nom_produi
        holder.uniteProduit.text = data.unite.toString()
        holder.prixProduit.text = data.prix.toString()
        holder.produits=data
        holder.numCommande=num_commande
    }
}




