package com.example.appdedestrubition.addpters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.CrearConexionMySQL
import com.example.appdedestrubition.EnvoyerLesCommandes
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelVenLiv

class AdapterLivreur (val listVenLiv:ArrayList<modelVenLiv>,val numCommande:Int?): RecyclerView.Adapter<AdapterLivreur.ViewHolder>() {
        class ViewHolder(itemView: View,var livreur:modelVenLiv?=null,var numCommande: Int?=null) : RecyclerView.ViewHolder(itemView) {

            init {
                itemView.setOnClickListener {
                    val con=CrearConexionMySQL(itemView.context)
                    val res=con.cnx("SELECT * FROM `livreur` WHERE `login_livreur` LIKE '${livreur!!.login_livreur}' AND `mdp_livreur` LIKE '${livreur!!.MDP_livreur}'")
                    res!!.next()
                    con.extnoquery("UPDATE `commande` SET `etat_commande` = 'en attent', `id_livreur` = '${res.getInt("id_livreur")}' WHERE `commande`.`num_commande` = $numCommande;")
                    "UPDATE `commande` SET `etat_commande` = 'en attent', `id_livreur` = '${res.getInt("id_livreur")}' WHERE `commande`.`num_commande` = $numCommande;"
                    itemView.context.startActivity(Intent(itemView.context,EnvoyerLesCommandes::class.java))
                }
            }

            val nom: TextView =itemView.findViewById(R.id.nom_ven_liv)
            val prenom: TextView =itemView.findViewById(R.id.prenom_ven_liv)
            val login: TextView =itemView.findViewById(R.id.login_ven_liv)
            val mdp: TextView =itemView.findViewById(R.id.mdp_ven_liv)

        }

        override fun getItemCount(): Int {
            return listVenLiv.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.nom.text=listVenLiv[position].Nom_livreur
            holder.prenom.text=listVenLiv[position].Prenom_livreur
            holder.login.text="${holder.login.text} ${listVenLiv[position].login_livreur}"
            holder.mdp.text="${holder.mdp.text} ${listVenLiv[position].MDP_livreur}"
            holder.livreur=listVenLiv[position]
            holder.numCommande=numCommande
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflateLayout=
                LayoutInflater.from(parent.context).inflate(R.layout.item_ven_liv,parent,false)
            return ViewHolder(inflateLayout)
        }
    }
