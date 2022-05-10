package com.example.appdedestrubition

import android.content.Context
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

class CrearConexionMySQL(context: Context) {
    val con=context
    private val userMySQL = "ibra"
    private val passwordMySQL = "ibra2002"
    private val hostweb = "db4free.net"
    private val host = "192.168.1.51"
    private val port = "3306"
    private val dbName = "mini_projet"
    private val urlGetDBParameters = "autoReconnect=true&useSSL=false"

    //private final String urlGetDBParameters = "zeroDateTimeBehavior=convertToNull&profileSQL=true&useSSL=false";
    //private final String strConnectionMySQLLocal = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?autoReconnect=true&useSSL=false";
    private val strConnectionMySQLLocal = "jdbc:mysql://192.168.1.51:3306/mini_projet?autoReconnect=true&useSSL=false";
   // private val strConnectionMySQLLocal = "jdbc:mysql://$host:$port/$dbName?$urlGetDBParameters"
    private val strConnectionMySQLWeb = "jdbc:mysql://$hostweb:$port/$dbName?$urlGetDBParameters"
    private val driverClassName = "com.mysql.jdbc.Driver"
     var connection: Connection? = null

    init {
        Log.e("avant_conx" ,"no prblm")
        try {
            Class.forName(driverClassName)
            connection = DriverManager.getConnection(strConnectionMySQLLocal, userMySQL, passwordMySQL)
        }catch (e:SQLException){
            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()
        }catch (e:ClassNotFoundException){
            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()
        }

        Log.e("apres conx" ,"no prblm")
    }
    fun cnx(rqt:String): ResultSet? {
        if (connection==null){
            Toast.makeText(con,"no cnx",Toast.LENGTH_SHORT).show()
        }
        return connection?.createStatement()?.executeQuery(rqt)
    }
}