package com.example.yanda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_success)

        val btnBackLogin = findViewById<Button>(R.id.btnBackLogin)

        btnBackLogin.setOnClickListener {
            startActivity(Intent(this, com.example.yanda.Home.pertemuan3.LoginActivity::class.java))
            finish()
        }
    }
}