package com.example.yanda.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yanda.BaseActivity
import com.example.yanda.GmailInputActivity
import com.example.yanda.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔵 LOGIN BUTTON
        binding.btnLogin.setOnClickListener {

            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            val sp = getSharedPreferences("USER_DATA", MODE_PRIVATE)
            val savedUsername = sp.getString("username", "")
            val savedPassword = sp.getString("password", "")

            // ❌ BELUM REGISTER
            if (savedUsername!!.isEmpty() || savedPassword!!.isEmpty()) {
                showError("Silakan register terlebih dahulu")
                return@setOnClickListener
            }

            // ❌ INPUT KOSONG
            if (username.isEmpty() || password.isEmpty()) {
                showError("Username dan password wajib diisi")
                return@setOnClickListener
            }

            // 🔥 VALID LOGIN B3
            val isDummyLogin = username == password
            val isSavedLogin =
                username == savedUsername && password == savedPassword

            if (isDummyLogin || isSavedLogin) {
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                showError("Username atau password salah")
            }
        }

        // 🟢 REGISTER
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, GmailInputActivity::class.java))
        }
    }

    // 🔥 ERROR DIALOG
    private fun showError(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Login Gagal")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}