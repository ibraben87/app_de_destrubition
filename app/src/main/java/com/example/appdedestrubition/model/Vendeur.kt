package com.example.appdedestrubition.model

import com.example.appdedestrubition.model.Commande
import com.example.appdedestrubition.model.Societe
import com.example.appdedestrubition.model.Categorie
import java.util.ArrayList

class Vendeur(var societe: List<Societe> = ArrayList(), var Nom_vendeur: String? = null,
              var ID_vendeur: Int = 0, var MDP_vendeur: String? = null,
              var Prenom_vendeur: String? = null, var Login_vendeur: String? = null
) {
    fun prendreLaCommande() {}
    fun creerNewClient() {}
    fun envoyerLaCommande() {}
    fun consulterLaListeDesProduits() {}
    fun authentification() {}
}