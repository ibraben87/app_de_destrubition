package com.example.appdedestrubition

import android.annotation.SuppressLint
import android.content.Context
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import java.lang.Exception
import android.os.AsyncTask;
import android.os.AsyncTask.execute
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

@Suppress("DEPRECATION")
class CrearConexionMySQL(context: Context?):AsyncTask<String?, Void?, String?>()  {
    @SuppressLint("StaticFieldLeak")
    val con=context
    private val userMySQL = "ibra"
    private val passwordMySQL = "ibra2002"
    private val hostweb = "db4free.net"
    private val host = "192.168.1.41"
    private val port = "3306"
    private val dbName = "mini_projet"
    private val urlGetDBParameters = "autoReconnect=true&useSSL=false"
    //private final String urlGetDBParameters = "zeroDateTimeBehavior=convertToNull&profileSQL=true&useSSL=false";
    //private final String strConnectionMySQLLocal = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?autoReconnect=true&useSSL=false";
    private val strConnectionMySQLLocal = "jdbc:mysql://$host:3306/mini_projet?$urlGetDBParameters";
   // private val strConnectionMySQLLocal = "jdbc:mysql://$host:$port/$dbName?$urlGetDBParameters"
    private val strConnectionMySQLWeb = "jdbc:mysql://$hostweb:$port/$dbName?$urlGetDBParameters"
    private val driverClassName = "com.mysql.jdbc.Driver"
     var connection: Connection? = null

    fun cnx(rqt:String): ResultSet? {
        if (connection==null){
            Toast.makeText(con,"no cnx",Toast.LENGTH_SHORT).show()
        }
        return connection?.createStatement()?.executeQuery(rqt)
    }
    @Deprecated("Deprecated in Java")
    override fun onPreExecute() {
        super.onPreExecute()
        Toast.makeText(con, "Please wait...", Toast.LENGTH_SHORT)
            .show()
    }

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg p0: String?): String? {
        try {
            Class.forName(driverClassName)
            connection = DriverManager.getConnection(strConnectionMySQLLocal, userMySQL, passwordMySQL)
            Toast.makeText(con, "rak ghalt", Toast.LENGTH_SHORT)
                .show()
        }catch (e:SQLException){
            Toast.makeText(con,e.toString(),Toast.LENGTH_SHORT).show()
        }catch (e:ClassNotFoundException){
            Toast.makeText(con,e.toString(),Toast.LENGTH_SHORT).show()
        }
        return ""
    }

}