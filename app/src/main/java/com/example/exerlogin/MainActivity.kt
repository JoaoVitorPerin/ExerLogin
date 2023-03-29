package com.example.exerlogin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Login"

        var button: Button = findViewById<Button>(R.id.cadastrar)
        button.setOnClickListener({
            val intent = Intent(this@MainActivity, ExerCadastro::class.java)
            startActivity(intent)
        })
    }

    val listaLogin = listOf<String>("jperin", "annalol")
    val listaSenha = listOf<String>("123456", "321123")

    fun login(view: View){

        var login = findViewById<EditText>(R.id.login).text.toString()
        var senha = findViewById<EditText>(R.id.senha).text.toString()

        if (listaLogin.contains(login) && listaSenha.contains(senha)){
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Atenção!")
            builder.setMessage("Login efetuado!")
            builder.create().show()

            findViewById<EditText>(R.id.login).setText("")
            findViewById<EditText>(R.id.senha).setText("")
        } else{
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Atenção!")
            builder.setMessage("Usuario ou senha incorretos!")
            builder.setNegativeButton(android.R.string.ok, null)
            builder.create().show()
        }
    }

}