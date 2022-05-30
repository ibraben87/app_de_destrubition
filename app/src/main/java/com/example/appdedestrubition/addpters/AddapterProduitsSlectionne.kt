package com.example.appdedestrubition.addpters

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.CrearConexionMySQL
import com.example.appdedestrubition.R
import com.example.appdedestrubition.Update_produit
import com.example.appdedestrubition.model.modelItemCommande
import com.example.appdedestrubition.model.modelProduit
import com.example.appdedestrubition.produits_selectionnes

class AddapterProduitsSlectionne(produits: ArrayList<modelItemCommande>, num_comande: Int? = null) :
    RecyclerView.Adapter<AddapterProduitsSlectionne.ViewHolder>() {
    val Produits = produits
    val numCommande = num_comande

    class ViewHolder(
        itemView: View,
        var produit_selc: modelItemCommande? = null,
        var numCommande: Int? = null,
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val builder = AlertDialog.Builder(itemView.context)
                val Inflater: LayoutInflater = LayoutInflater.from(itemView.context)
                val dialogLayout = Inflater.inflate(R.layout.qte, null)
                val qte = dialogLayout.findViewById<EditText>(R.id.qte)
                var qQte: String? = null
                with(builder) {
                    setTitle("entrer la quantite")
                    setPositiveButton("ok") { dialog, wich ->
                        qQte = qte.text.toString()
                        val con = CrearConexionMySQL(itemView.context)
                        val result =
                            con.cnx("SELECT * FROM `produit` WHERE `nom_produit` = '${produit_selc!!.nom_produit}'")
                        result!!.next()
                        con.extnoquery("UPDATE `commander` SET `quantite``` = '$qQte' WHERE `commander`.`num_commande` = $numCommande AND `commander`.`num_produit` = ${result.getInt("num_produit")};")
                        val Intent_commande =
                            Intent(itemView.context, produits_selectionnes::class.java)
                        Intent_commande.putExtra("numerota3lacommande", numCommande)
                        itemView.context.startActivity(Intent_commande)
                    }
                    setNegativeButton("cancel") { dialog, wich ->
                    }
                    setView(dialogLayout)
                    show()
                }
            }
        }

        val nomProduit = itemView.findViewById<TextView>(R.id.nom_produit)
        val qte = itemView.findViewById<TextView>(R.id.qte_prodect)
        val prix = itemView.findViewById<TextView>(R.id.prix)
        val total = itemView.findViewById<TextView>(R.id.total)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_prodect, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Produits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: modelItemCommande = Produits[position]
        holder.nomProduit.text = data.nom_produit
        holder.qte.text = "${data.qte}*${data.unite}"
        holder.prix.text = data.prix.toString()
        holder.total.text = data.total.toString()
        holder.produit_selc = data
        holder.numCommande = numCommande
    }
}