package com.example.appdedestrubition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*

class new_client : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_client)
        val nom: EditText = findViewById(R.id.nom)
        val prenom: EditText = findViewById(R.id.prenom)
        val localisation: EditText = findViewById(R.id.addresse)
        val phone: EditText = findViewById(R.id.Phone)
        val credit: EditText = findViewById(R.id.credit)
        val spinner: Spinner = findViewById(R.id.spinner_categorie)
        val submit: Button = findViewById(R.id.submit_new_client)
        val con = CrearConexionMySQL(this)
        val res = con.cnx("SELECT * FROM `Categorie`")
        val options = ArrayList<String>()
        options.add("choisi une categorie")
        var categorie: String = ""
        do {
            res!!.next()
            options.add(res.getString("nom_categorie"))
        } while (res!!.isLast == false)
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                categorie = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                categorie = ""
            }
        }
        submit.setOnClickListener {
            if (categorie == "") {
                Toast.makeText(this, "svp choisi une categorie", Toast.LENGTH_SHORT).show()
            } else {
                con.extnoquery("INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `credit`, `localisation`, `Num`, `nom_categorie`) VALUES (NULL, '${nom.text}', '${prenom.text}', '${credit.text}', '${localisation.text}', '${phone.text}', '$categorie');")
            }
        }
    }
}