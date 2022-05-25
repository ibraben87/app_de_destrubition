package com.example.appdedestrubition

import android.app.DownloadManager
import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.sql.ResultSet

@Suppress("DEPRECATION")
class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email: EditText = findViewById(R.id.login)
        val password: EditText = findViewById(R.id.password)
        val cnx: Button = findViewById(R.id.cnx)
        cnx.setOnClickListener {
            val btn = intent?.extras?.getString("user").toString()
            log(email.text.toString(), password.text.toString(), btn)

        }

    }

    fun log(email: String, password: String, btn: String) {
        if (btn == "livreur") {
            val resu: ResultSet? =
                CrearConexionMySQL(this).cnx("SELECT * FROM `livreur` WHERE `login_livreur` = '$email' AND `mdp_livreur` = '$password'")
            resu?.last()
            if (resu?.row != 0) {
                val Liv = Intent(this, MainActivity_Livreur::class.java)
                startActivity(Liv)
            } else {
                Toast.makeText(this, "try again", Toast.LENGTH_SHORT).show()
            }
        } else if (btn == "vendeur") {
            val resu: ResultSet? =
                CrearConexionMySQL(this).cnx("SELECT * FROM `vendeur` WHERE `login_vendeur` = '$email' AND `mdp_vendeur` = '$password'")
            resu?.last()
            if (resu?.row != 0) {
                val Liv = Intent(this, Vendeur::class.java)
                startActivity(Liv)
            } else {
                Toast.makeText(this, "try again", Toast.LENGTH_SHORT).show()
            }
        } else if (btn == "societe") {
            val resu: ResultSet? =
                CrearConexionMySQL(this).cnx("SELECT * FROM `societe` WHERE `login_societe` = '$email' AND `mdp_societe` = '$password'")
            resu?.last()
            if (resu?.row != 0) {
                Toast.makeText(this, resu!!.row.toString(),Toast.LENGTH_SHORT).show()
                val Liv = Intent(this, societe::class.java)
                startActivity(Liv)
            } else {
                Toast.makeText(this, "try again", Toast.LENGTH_SHORT).show()
            }

        }

    }
}





