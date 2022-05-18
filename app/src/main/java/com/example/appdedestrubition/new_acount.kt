package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class new_acount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_acount)
        val nom:EditText=findViewById(R.id.nom)
        val prenom:EditText=findViewById(R.id.prenom)
        val email:EditText=findViewById(R.id.login)
        val password:EditText=findViewById(R.id.password)
        val livreur:RadioButton=findViewById(R.id.livreur_radio)
        val vendeur:RadioButton=findViewById(R.id.vendeur_radio)
        val submit:Button=findViewById(R.id.submit)
        submit.setOnClickListener {
            if (livreur.isChecked==true){
                CrearConexionMySQL(this).extnoquery("INSERT INTO `livreur` (`id_livreur`, `nom_livreur`, `prenom_livreur`, `login_livreur`, `mdp_livreur`, `id_societe`) VALUES (NULL, '${nom.text}', '${prenom.text}', '${email.text}', '${password.text}', '1');")
            }else if (vendeur.isChecked==true){
                CrearConexionMySQL(this).extnoquery("INSERT INTO `vendeur` (`id_vendeur`, `nom_vendeur`, `prenom_vendeur`, `login_vendeur`, `mdp_vendeur`, `id_societe`) VALUES (NULL, '${nom.text}', '${prenom.text}', '${email.text}', '${password.text}', '1');")
            }
        }

    }
}