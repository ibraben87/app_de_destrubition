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
    private val userMySQL = "sql11493706"
    private val passwordMySQL:String = "fdfWHJHgHR"
    private val hostweb = "sql11.freemysqlhosting.net"
    private val host = "192.168.1.37"
    private val port = "3306"
    private val dbName = "sql11493706"

    //private final String urlGetDBParameters = "zeroDateTimeBehavior=convertToNull&profileSQL=true&useSSL=false";
    //private final String strConnectionMySQLLocal = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?autoReconnect=true&useSSL=false";
    private var strConnectionMySQLLocal = "jdbc:mysql://192.168.43.7:3306/miniprojet?autoReconnect=true&useSSL=false"
    private val strConnectionMySQLWeb = "jdbc:mysql://$hostweb:$port/$dbName?autoReconnect=true&useSSL=false"
    private val driverClassName = "com.mysql.jdbc.Driver"
    var connection: Connection? = null


    init {
        try {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            Class.forName("com.mysql.jdbc.Driver")
            connection = DriverManager.getConnection(strConnectionMySQLWeb,userMySQL,passwordMySQL)
            if (connection!=null){
                Toast.makeText(con,"ro7 dir dodo ro7",Toast.LENGTH_SHORT).show()
            }
        }catch (e:SQLException){
            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()
        }catch (e:ClassNotFoundException){
            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()
        }
    }
    fun cnx(rqt:String): ResultSet? {
        return connection?.createStatement()?.executeQuery(rqt)
    }

    fun extnoquery(rqt: String){
        connection?.prepareStatement(rqt)?.executeUpdate()
    }
}