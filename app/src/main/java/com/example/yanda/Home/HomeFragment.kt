package com.example.yanda.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.yanda.Home.pertemuan10.TenthActivity
import com.example.yanda.Home.pertemuan2.BangunRuangActivity
import com.example.yanda.Home.pertemuan3.LoginActivity
import com.example.yanda.Home.pertemuan4.Custom2Activity
import com.example.yanda.WebViewActivity
import com.example.yanda.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.title = "Home"

        // Bangun Ruang
        binding.btnBangunRuang.setOnClickListener {
            val intent = Intent(requireContext(), BangunRuangActivity::class.java)
            intent.putExtra("judul", "Bangun Ruang")
            startActivity(intent)
        }

        // Custom 2
        binding.btnCustom2.setOnClickListener {
            startActivity(
                Intent(requireContext(), Custom2Activity::class.java)
            )
        }

        // Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(requireContext(), WebViewActivity::class.java)
            )
        }

        // ListView
        binding.btnListView.setOnClickListener {
            startActivity(
                Intent(requireContext(), ListActivity::class.java)
            )
        }

        // Pertemuan 10
        binding.btnPertemuan10.setOnClickListener {
            startActivity(
                Intent(requireContext(), TenthActivity::class.java)
            )
        }

        // Logout
        binding.btnLogout.setOnClickListener { v ->
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    startActivity(
                        Intent(requireContext(), LoginActivity::class.java)
                    )
                    activity.finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(
                        v,
                        "Logout dibatalkan",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}