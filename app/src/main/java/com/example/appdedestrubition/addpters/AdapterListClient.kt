package com.example.appdedestrubition.addpters

import android.content.Context
import android.widget.ArrayAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appdedestrubition.R
import android.widget.TextView
import com.example.appdedestrubition.User

class AdapterListClient (context: Context, resource: Int, users: List<User?>) :
    ArrayAdapter<User?>(context, resource, users) {



        var layoutInflater: LayoutInflater
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val rowView: View = layoutInflater.inflate(R.layout.activity_spinner_client, null, true)
            val user: User? = getItem(position)
            val textView = rowView.findViewById<View>(R.id.nom_client_commande) as TextView
            /*val imageView = rowView.findViewById<View>(R.id.imageIcon) as ImageView
            textView.setText(user.name)
            imageView.setImageResource(user.image)*/
            return rowView
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            if (convertView == null) convertView = layoutInflater.inflate(R.layout.activity_spinner_client, parent, false)
            val user: User? = getItem(position)
            val textView = convertView!!.findViewById<View>(R.id.nom_client_commande) as TextView
            /*  val imageView = convertView.findViewById<View>(R.id.imageIcon) as ImageView
              textView.setText(user.name)
              imageView.setImageResource(user.image)*/
            return convertView
        }

        init {
            layoutInflater = LayoutInflater.from(context)
        }
 }