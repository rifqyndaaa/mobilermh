package com.example.yanda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.yanda.Home.pertemuan2.BangunRuangActivity
import com.example.yanda.Home.pertemuan3.LoginActivity
import com.example.yanda.Home.pertemuan4.Custom2Activity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBangunRuang = findViewById<Button>(R.id.btnBangunRuang)
        val btnCustom1 = findViewById<Button>(R.id.btnCustom1)
        val btnCustom2 = findViewById<Button>(R.id.btnCustom2)
        val btnWebsite = findViewById<Button>(R.id.btnWebsite)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Bangun Ruang
        btnBangunRuang.setOnClickListener {
            val intent = Intent(this, BangunRuangActivity::class.java)
            intent.putExtra("judul", "Bangun Ruang")
            intent.putExtra("deskripsi", "Hitung luas segitiga dan volume balok")
            startActivity(intent)
        }

        // Custom 1

        // Custom 2
        btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("judul", "Halaman Custom 2")
            intent.putExtra("deskripsi", "Ini halaman custom kedua dengan gambar")
            startActivity(intent)
        }

        // Website
        btnWebsite.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // Logout
        btnLogout.setOnClickListener { view ->

            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }

                .setNegativeButton("Tidak") { _, _ ->

                    Snackbar.make(
                        view,
                        "Logout dibatalkan",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                .show()
        }
    }
}