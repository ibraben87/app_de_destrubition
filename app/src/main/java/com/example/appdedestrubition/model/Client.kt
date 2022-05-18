package com.example.appdedestrubition.model

import com.example.appdedestrubition.model.Commande
import com.example.appdedestrubition.model.Societe
import com.example.appdedestrubition.model.Categorie
import java.util.ArrayList

class Client(var commande: List<Commande> = ArrayList(), var nom_client: String? = null,
             var prenom_client: String? = null, var credit_client: Double = 0.0,
             var localisation_client: String? = null, var ID_client: Int = 0
) {
}