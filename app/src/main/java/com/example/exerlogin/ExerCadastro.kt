package com.example.exerlogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class ExerCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exer_cadastro)
        title = "Cadastro de usuário"

        val lista = listOf<String>("USER", "ADM")

        val teste = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(
            this@ExerCadastro,
            android.R.layout.simple_spinner_item,
            lista
        )
        teste.adapter = adapter
    }

    fun cadastrar(view: View){
        var login = findViewById<EditText>(R.id.textLogin).text.toString()
        var senha = findViewById<EditText>(R.id.textSenha).text.toString()
        var nome = findViewById<EditText>(R.id.textNome).text.toString()

        if (login != "" && senha != "" && nome != ""){
            val builder = AlertDialog.Builder(this@ExerCadastro)
            builder.setTitle("Atenção!")
            builder.setMessage("Cadastro efetuado!")
            builder.create().show()
            findViewById<EditText>(R.id.textLogin).setText("")
            findViewById<EditText>(R.id.textSenha).setText("")
            findViewById<EditText>(R.id.textNome).setText("")

        }else{
            val builder = AlertDialog.Builder(this@ExerCadastro)
            builder.setTitle("Atenção!")
            builder.setMessage("Cadastro não efetuado! Cheque as suas informações!")
            builder.setNegativeButton(android.R.string.ok, null)
            builder.create().show()
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@ExerCadastro)
        builder.setTitle("Atenção!")
        builder.setMessage("Voce deseja realmente voltar?")
        builder.setNegativeButton(android.R.string.cancel, null)
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            finish()
        }
        builder.create().show()
    }
}