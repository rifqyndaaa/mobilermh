package com.example.yanda.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yanda.BaseActivity // Import BaseActivity
import com.example.yanda.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // GANTI MainActivity MENJADI BaseActivity
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}