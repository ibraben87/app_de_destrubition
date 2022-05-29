package com.example.appdedestrubition

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdaptor(private val productsList :ArrayList<products>):
    RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView =LayoutInflater.from(parent.context).inflate(R.layout.item_prodect,parent,false)
        return MyViewHolder(itemView)
    }


    override fun getItemCount(): Int {
return productsList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = productsList [position]
        holder.txt1.text = currentItem.nom_produit
        holder.txt2.text = currentItem.prix.toString()
        holder.txt3.text = currentItem.total.toString()

    }
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        val txt1 :TextView =itemView.findViewById(R.id.nom_produit)
        val txt2 :TextView =itemView.findViewById(R.id.prix)
        val txt3 :TextView =itemView.findViewById(R.id.total)


    }


}