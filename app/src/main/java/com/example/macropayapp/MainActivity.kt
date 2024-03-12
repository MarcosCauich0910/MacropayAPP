package com.example.macropayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.macropayapp.R.id.custom_button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(custom_button)


        button.setOnClickListener {
            Toast.makeText(this, "¡Bienvenido a mi aplicación !", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)

        }
    }
}