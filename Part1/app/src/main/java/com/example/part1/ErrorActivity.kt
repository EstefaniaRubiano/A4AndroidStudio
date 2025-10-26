package com.example.part1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val name = intent.getStringExtra("USERNAME")
        val userNumber = intent.getIntExtra("USERNUMBER", 0)
        val correctNumber = intent.getIntExtra("CORRECTNUMBER", 0)

        tvMessage.text = "Llàstima, $name \nVas triar el $userNumber però el número era $correctNumber"

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}