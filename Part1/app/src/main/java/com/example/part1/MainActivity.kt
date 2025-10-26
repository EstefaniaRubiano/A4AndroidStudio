package com.example.part1

import android.content.Intent
import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assignar les variables als elements del layout
        val tvDate = findViewById<TextView>(R.id.tvDate)
        val etName = findViewById<EditText>(R.id.etName)
        val btnStart = findViewById<Button>(R.id.btnStart)

        // Donar format a la data actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        tvDate.text = "Avui és ${dateFormat.format(Date())}"

        btnStart.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, StartActivity::class.java)
                // Enviem el nom a la seguent pantalla
                intent.putExtra("USERNAME", name)
                startActivity(intent) // Obrim la seguent Activity
            } else {
                etName.error = "Introdueix el teu nom"
            }
        }
    }
}