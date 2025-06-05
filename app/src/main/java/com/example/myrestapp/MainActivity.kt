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

        val users = arrayOf("User1", "User2", "User3")
        val passwords = arrayOf("psw1", "psw2", "psw3")

        val username = findViewById<EditText>(R.id.editText_username)
        val password = findViewById<EditText>(R.id.editText_password)
        val btnLogin = findViewById<Button>(R.id.button_login)



        btnLogin.setOnClickListener{
            val usernameString = username.text.toString()
            val passwordString = password.text.toString()
            for(i in users.indices) {
                if(users[i] == usernameString && passwords[i] == passwordString){
                    val myIntent = Intent(this, MenuActivity::class.java)
                    startActivity(myIntent)
                }
            }
        }
    }
}