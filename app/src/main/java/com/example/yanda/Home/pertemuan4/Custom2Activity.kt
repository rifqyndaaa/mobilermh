package com.example.yanda.Home.pertemuan4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yanda.R

class Custom2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom2)

        val tvJudul = findViewById<TextView>(R.id.tvJudul)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDeskripsi)
        val ivGambar = findViewById<ImageView>(R.id.ivGambar)

        tvJudul.text = intent.getStringExtra("judul")
        tvDeskripsi.text = intent.getStringExtra("deskripsi")
        ivGambar.setImageResource(R.drawable.ic_launcher_foreground)
    }
}