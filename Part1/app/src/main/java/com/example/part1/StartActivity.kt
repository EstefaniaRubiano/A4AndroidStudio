package com.example.part1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val tvName = findViewById<TextView>(R.id.tvName)
        val etNumber = findViewById<EditText>(R.id.etNumber)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Recupero el nom enviat desde la MainActivity
        val userName = intent.getStringExtra("USERNAME")
        tvName.text = "Hola, $userName! Endevina un número del 1 al 3:"

        btnCheck.setOnClickListener {
            val userNumber = etNumber.text.toString().toIntOrNull()

            // Genera un numero aleatori del 1 al 3
            val randomNumber = Random.nextInt(1, 4)

             if (userNumber == randomNumber) {
                // Si encerta
                val intent = Intent(this, SuccessActivity::class.java)
                intent.putExtra("USERNAME", userName)
                intent.putExtra("USERNUMBER", userNumber)
                intent.putExtra("CORRECTNUMBER", randomNumber)
                startActivity(intent)
            } else {
                // Si falla
                val intent = Intent(this, ErrorActivity::class.java)
                intent.putExtra("USERNAME", userName)
                intent.putExtra("USERNUMBER", userNumber)
                intent.putExtra("CORRECTNUMBER", randomNumber)
                startActivity(intent)
            }
        }

        // Botó per tornar enrere
        btnBack.setOnClickListener {
            onBackPressed() // tanca aquesta Activity i torna a la MainActivity
        }
    }
}