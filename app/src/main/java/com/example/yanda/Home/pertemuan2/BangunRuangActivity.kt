package com.example.yanda.Home.pertemuan2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.yanda.R

class BangunRuangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { // Perbaikan typo dari savedInAstanceState
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bangun_ruang)

        // --- 1. SETUP TOOLBAR & BACK BUTTON ---
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Aktifkan tombol back (panah kiri)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // --- 2. DATA DARI INTENT ---
        val tvJudul = findViewById<TextView>(R.id.tvJudul)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDeskripsi)

        val judul = intent.getStringExtra("judul") ?: "Bangun Ruang"
        val deskripsi = intent.getStringExtra("deskripsi") ?: "Deskripsi tidak tersedia"

        tvJudul.text = judul
        supportActionBar?.title = judul // Sinkronkan judul Toolbar dengan data Intent
        tvDeskripsi.text = deskripsi

        // --- 3. LOGIKA HITUNG SEGITIGA ---
        val etAlas = findViewById<EditText>(R.id.etAlas)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnSegitiga = findViewById<Button>(R.id.btnHitungSegitiga)
        val tvHasilSegitiga = findViewById<TextView>(R.id.tvHasilSegitiga)

        btnSegitiga.setOnClickListener {
            val alas = etAlas.text.toString().toDoubleOrNull()
            val tinggi = etTinggi.text.toString().toDoubleOrNull()

            if (alas != null && tinggi != null) {
                val hasil = 0.5 * alas * tinggi
                tvHasilSegitiga.text = "Luas Segitiga: $hasil"
            } else {
                tvHasilSegitiga.text = "Mohon isi alas dan tinggi dengan benar"
            }
        }

        // --- 4. LOGIKA HITUNG BALOK ---
        val etPanjang = findViewById<EditText>(R.id.etPanjang)
        val etLebar = findViewById<EditText>(R.id.etLebar)
        val etTinggiBalok = findViewById<EditText>(R.id.etTinggiBalok)
        val btnBalok = findViewById<Button>(R.id.btnHitungBalok)
        val tvHasilBalok = findViewById<TextView>(R.id.tvHasilBalok)

        btnBalok.setOnClickListener {
            val p = etPanjang.text.toString().toDoubleOrNull()
            val l = etLebar.text.toString().toDoubleOrNull()
            val t = etTinggiBalok.text.toString().toDoubleOrNull()

            if (p != null && l != null && t != null) {
                val hasil = p * l * t
                tvHasilBalok.text = "Volume Balok: $hasil"
            } else {
                tvHasilBalok.text = "Input tidak valid"
            }
        }
    }

    // Fungsi agar tombol Back di Toolbar bisa menutup activity
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}