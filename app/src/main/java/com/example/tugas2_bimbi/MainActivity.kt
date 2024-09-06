package com.example.tugas2_bimbi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etuser: TextView
    private lateinit var password: TextView
    private lateinit var submithere: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etuser = findViewById(R.id.user)
        password = findViewById(R.id.password)
        submithere = findViewById(R.id.submitHere)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        submithere.setOnClickListener {
            val etuser = etuser.text.toString()
            val password = password.text.toString()

            if (etuser == "admin" && password == "123456") {
                val intent = Intent(this, Page2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }

        }
    }
}