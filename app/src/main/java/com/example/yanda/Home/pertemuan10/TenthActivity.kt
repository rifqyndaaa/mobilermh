package com.example.yanda.Home.pertemuan10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yanda.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Pertemuan 10"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Adapter
        val tabsAdapter = TenthTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        // TabLayout + ViewPager2
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.setIcon(android.R.drawable.ic_menu_view)

                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }

                1 -> {
                    tab.text = "Tab B"
                    tab.setIcon(android.R.drawable.ic_menu_info_details)

                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 5
                }

                2 -> {
                    tab.text = "Produk"
                    tab.setIcon(android.R.drawable.ic_menu_gallery)
                }
            }

        }.attach()
    }
}