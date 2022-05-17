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
        val email:EditText=findViewById(R.id.login)
        val password:EditText=findViewById(R.id.password)
        val cnx:Button=findViewById(R.id.cnx)
        val btn="societe"
        cnx.setOnClickListener {
            log(email.text.toString(),password.text.toString(), btn)
            val btn=intent?.extras?.getString("user").toString()
            if(btn=="livreur") {
                val Liv = Intent(this, MainActivity_Livreur::class.java)
                startActivity(Liv)
            }else if (btn=="vendeur"){
                val Liv = Intent(this, Vendeur::class.java)
                startActivity(Liv)
            }else if (btn=="societe"){
                val Liv = Intent(this, societe::class.java)
                startActivity(Liv)
            }
        }

    }
    fun log(email:String,password: String,btn:String){
        val resu: ResultSet? =CrearConexionMySQL(this).cnx("SELECT * FROM `$btn")
        resu?.next()
        if (resu!=null){Toast.makeText(this,resu.getString("login_societe") ,Toast.LENGTH_SHORT).show()}
        resu?.toString()

    }
}



