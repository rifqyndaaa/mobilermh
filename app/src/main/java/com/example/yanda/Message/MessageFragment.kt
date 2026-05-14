package com.example.yanda.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yanda.databinding.FragmentMessage2Binding // Sesuaikan jika nama layoutmu fragment_message2

class MessageFragment : Fragment() {

    private var _binding: FragmentMessage2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessage2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kamu bisa mengisi data text via code di sini jika perlu
        // contoh: binding.tvAbout.text = "Aplikasi Bina Desa"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}