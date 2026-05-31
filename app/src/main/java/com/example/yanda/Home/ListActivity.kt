package com.example.yanda.Home

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yanda.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    // DATA LISTVIEW
    private val dataList = listOf(
        "👤 Profile",
        "⚙️ Settings",
        "🔒 Privacy Policy",
        "ℹ️ About App",
        "📞 Contact",
        "🚪 Logout"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TITLE APPBAR
        supportActionBar?.title = "Menu Settings"

        // ARRAY ADAPTER
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            dataList
        )

        // SET ADAPTER KE LISTVIEW
        binding.listViewItems.adapter = adapter

        // CLICK ITEM LISTVIEW
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->

            val selectedItem = dataList[position]

            when (position) {

                0 -> {
                    Toast.makeText(
                        this,
                        "Membuka Profile",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                1 -> {
                    Toast.makeText(
                        this,
                        "Membuka Settings",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                2 -> {
                    Toast.makeText(
                        this,
                        "Membuka Privacy Policy",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                3 -> {
                    Toast.makeText(
                        this,
                        "Tentang Aplikasi",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                4 -> {
                    Toast.makeText(
                        this,
                        "Menghubungi Contact",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                5 -> {
                    Toast.makeText(
                        this,
                        "Logout Berhasil",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}