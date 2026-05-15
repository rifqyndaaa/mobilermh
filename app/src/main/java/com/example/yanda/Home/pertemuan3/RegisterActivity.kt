package com.example.yanda

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        val email = intent.getStringExtra("email")
        etEmail.setText(email)
        etEmail.isEnabled = false

        btnRegister.setOnClickListener {

            val nama = etNama.text.toString().trim()
            val emailFix = etEmail.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // ❌ VALIDASI WAJIB
            if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
                etNama.error = if (nama.isEmpty()) "Wajib diisi" else null
                etUsername.error = if (username.isEmpty()) "Wajib diisi" else null
                etPassword.error = if (password.isEmpty()) "Wajib diisi" else null
                return@setOnClickListener
            }

            if (password.length < 6) {
                etPassword.error = "Password minimal 6 karakter"
                return@setOnClickListener
            }

            if (username.contains(" ")) {
                etUsername.error = "Username tidak boleh ada spasi"
                return@setOnClickListener
            }

            // 💾 SIMPAN DATA
            val sp: SharedPreferences =
                getSharedPreferences("USER_DATA", MODE_PRIVATE)

            val editor = sp.edit()
            editor.putString("nama", nama)
            editor.putString("email", emailFix)
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            // 🔥 PESAN BERHASIL
            Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()

            // 🔥 MASUK HOME
            startActivity(Intent(this, BaseActivity::class.java))
            finish()
        }
    }
}