package com.example.appdedestrubition.model

import com.example.appdedestrubition.model.Commande
import com.example.appdedestrubition.model.Societe
import com.example.appdedestrubition.model.Categorie
import java.util.ArrayList

class Produit(
    var nom_produit: String? = null, var photo_produit: Int,
    var Unite_carton: Int, var categorie: List<Categorie>? = ArrayList(),
    var commande: Commande? = null
) {
}