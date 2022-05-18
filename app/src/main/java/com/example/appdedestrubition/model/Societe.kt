package com.example.appdedestrubition.model

import com.example.appdedestrubition.model.Commande
import com.example.appdedestrubition.model.Societe
import com.example.appdedestrubition.model.Categorie

class Societe(var Login: String? = null, var ID_societe: Int = 0, var MDP_societe: String? = null) {
    fun creerComptes() {}
    fun consulterLesCommandes() {}
    fun ajouterLesProduits() {}
    fun modefierLesProduits() {}
    fun cosulterCommande() {}
    fun modfierCommande() {}
    fun envoyerLesCommandes() {}
    fun authentification() {}
}