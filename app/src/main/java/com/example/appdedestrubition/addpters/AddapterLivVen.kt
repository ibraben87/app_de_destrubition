package com.example.appdedestrubition.addpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdedestrubition.R
import com.example.appdedestrubition.model.modelVenLiv


class AddapterLivVen(val listVenLiv:ArrayList<modelVenLiv>): RecyclerView.Adapter<AddapterLivVen.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nom:TextView=itemView.findViewById(R.id.nom_ven_liv)
        val prenom:TextView=itemView.findViewById(R.id.prenom_ven_liv)
        val login:TextView=itemView.findViewById(R.id.login_ven_liv)
        val mdp:TextView=itemView.findViewById(R.id.mdp_ven_liv)

    }

    override fun getItemCount(): Int {
        return listVenLiv.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.text=listVenLiv[position].Nom_livreur
        holder.prenom.text=listVenLiv[position].Prenom_livreur
        holder.login.text="${holder.login.text} ${listVenLiv[position].login_livreur}"
        holder.mdp.text="${holder.mdp.text} ${listVenLiv[position].MDP_livreur}"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateLayout=LayoutInflater.from(parent.context).inflate(R.layout.item_ven_liv,parent,false)
        return ViewHolder(inflateLayout)
    }
}