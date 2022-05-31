package com.example.appdedestrubition.addpters

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.CrearConexionMySQL
import com.example.appdedestrubition.ListeProduitCommandes
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelConsCommande
import com.example.appdedestrubition.produits_selectionnes

class AdapterCommandesEnCours(
    commandes: ArrayList<modelConsCommande>,
) : RecyclerView.Adapter<AdapterCommandesEnCours.ViewHolder>() {
    val commandes = commandes

    class ViewHolder(itemView: View, var com_selc: modelConsCommande? = null) :
        RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {

                val builder = AlertDialog.Builder(itemView.context)

                val con = CrearConexionMySQL(itemView.context)

                val result = con.cnx("SELECT * FROM `client` WHERE `nom_client` LIKE '${com_selc!!.nom_client}'")
                result!!.last()

                with(builder) {
                    setTitle("${com_selc!!.nom_client}")
                    setMessage("localisation: ${result!!.getString("localisation")}\n total: ${com_selc!!.total}")
                    setPositiveButton("ok") { dialog, wich ->
                        val intent_DEtails_commnde=Intent(itemView.context,ListeProduitCommandes::class.java)
                        intent_DEtails_commnde.putExtra("numcommandeLivreur", com_selc!!.num_commande)
                        itemView.context.startActivity(intent_DEtails_commnde)
                    }
                    setNegativeButton("cancel") { dialog, wich ->
                    }
                    show()
                }
            }
        }

        val numCom = itemView.findViewById<TextView>(R.id.num_commande1)
        val nomClient = itemView.findViewById<TextView>(R.id.nom_client1)
        val total1 = itemView.findViewById<TextView>(R.id.total_comande1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_commande, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return commandes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: modelConsCommande = commandes[position]
        holder.nomClient.text = data.nom_client
        holder.numCom.text = data.num_commande.toString()
        holder.total1.text = data.total.toString()
        holder.com_selc = data
    }
}
