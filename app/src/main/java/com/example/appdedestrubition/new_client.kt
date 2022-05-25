package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class new_client : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_client)
        val nom: EditText =findViewById(R.id.nom)
        val prenom: EditText =findViewById(R.id.prenom)
        val localisation: EditText =findViewById(R.id.addresse)
        val phone: EditText =findViewById(R.id.Phone)
        val credit: EditText =findViewById(R.id.credit)
        val categorie: EditText =findViewById(R.id.categorie)
        val submit: Button =findViewById(R.id.submit)
        submit.setOnClickListener {
            CrearConexionMySQL(this).extnoquery("INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `credit`, `localisation`, `Num`, `nom_categorie`) VALUES (NULL, '${nom.text}', '${prenom.text}', '${credit.text}', '${localisation.text}', '${phone.text}', '${categorie.text}');")
        }


    }
}