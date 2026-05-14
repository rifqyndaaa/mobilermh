package com.example.yanda

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.yanda.databinding.ActivitySplashScreenBinding
import com.example.yanda.Home.pertemuan3.LoginActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.jvm.java

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout menggunakan ViewBinding
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {

            // Delay splash screen 2 detik
            delay(2000)

            // SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

            // Reset login setiap aplikasi dibuka
            sharedPref.edit().clear().apply()

            // Pindah ke AuthActivity
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))

            // Tutup splash screen
            finish()
        }
    }
}