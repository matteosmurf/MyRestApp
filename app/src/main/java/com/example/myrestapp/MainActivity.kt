package com.example.myrestapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = findViewById<EditText>(R.id.editText_username)
        val password = findViewById<EditText>(R.id.editText_password)
        val btnLogin = findViewById<Button>(R.id.button_login)

        val usernameString = username.text.toString()
        val passwordString = password.text.toString()

        btnLogin.setOnClickListener{
            if(usernameString.isEmpty() || passwordString.isEmpty()){
                Toast.makeText(this, "Inserisci username e password", Toast.LENGTH_SHORT).show()
            } else if (passwordString.length < 8){
                Toast.makeText(this, "La password deve essere almeno 8 caratteri", Toast.LENGTH_SHORT).show()
            } else {
                val myIntent = Intent(this, MenuActivity::class.java)
                startActivity(myIntent)
            }
        }
    }
}