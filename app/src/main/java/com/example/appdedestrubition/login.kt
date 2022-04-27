package com.example.appdedestrubition

import android.app.DownloadManager
import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
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

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email:EditText=findViewById(R.id.login)
        val password:EditText=findViewById(R.id.password)
        val cnx:Button=findViewById(R.id.cnx)
        cnx.setOnClickListener {
            cnx(email.text.toString(),password.text.toString())
            val btn=intent?.extras?.getString("user").toString()
            if(btn=="livreur"){
                //  val Liv=Intent(this,Livreur::class.java)
                //startActivity(Liv)
            }
        }

    }
    fun cnx(email:String,password: String){
        val lis=Response.Listener<String> {
                response ->  try {
            val jes=JSONObject(response)
            val succes:Boolean=jes.getBoolean("succes")
            if (succes){
                Toast.makeText(this,"cnx",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"no cnx",Toast.LENGTH_LONG).show()
            }
        }catch (e:JSONException){
            Toast.makeText(this,"err",Toast.LENGTH_LONG).show()
        }
        }
        val send=send(email,password,lis)
        val request:RequestQueue=Volley.newRequestQueue(this)
        request.add(send)
    }
    class send(email: String, password: String, listener: Response.Listener<String>) :
        StringRequest(
            Request.Method.POST,
            "http://192.168.1.41/mini_projet/login.php",
            listener,
            null
        ) {
        var map:MutableMap<String,String> = HashMap()

        init {
            map.put("email",email)
            map.put("password",password)
        }

        override fun getParams(): MutableMap<String, String>? {
            return map
        }
    }
}