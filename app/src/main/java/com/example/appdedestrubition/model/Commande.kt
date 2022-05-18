package com.example.appdedestrubition.model

import com.example.appdedestrubition.model.Commande
import com.example.appdedestrubition.model.Societe
import com.example.appdedestrubition.model.Categorie
import java.util.ArrayList

class Commande(var num_commande: String? = null, var date_commande: String? = null,
               var date_livraison: String? = null, var Total_commande: Double = 0.0,
               var vendeur: List<Vendeur> = ArrayList()
) {
}