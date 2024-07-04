package com.example.building3.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.building3.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emails = "dima04gemstv@gmail.com"

        binding.email.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                // Указываем "mailto:" для отправки по электронной почте
                data = android.net.Uri.parse("mailto:" + emails)
            }
            startActivity(intent)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}