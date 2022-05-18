package com.example.appdedestrubition.model

import java.util.ArrayList

class Livreur(var Nom_livreur: String?, var societe: List<Societe> = ArrayList(),
              var MDP_livreur: String? = null, var login_livreur: String? = null,
              var ID_livreur: Int = 0, var Prenom_livreur: String? = null)
{
    fun validerLaRecuperationDesCommandes() {}
    fun validerLaLaivraisoneEtLePaiment() {}
    fun authentification() {}
}