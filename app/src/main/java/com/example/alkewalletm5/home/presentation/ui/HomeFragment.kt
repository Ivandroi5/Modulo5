package com.example.alkewalletm5.home.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.alkewalletm5.R
import com.example.alkewalletm5.databinding.FragmentHomeBinding
import com.google.android.material.imageview.ShapeableImageView


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val btnNavSend: Button= binding.travelToSendMoney
        val btnNavReceive: Button = binding.travelToReceiveMoney
        val imgNavProfile: ShapeableImageView = binding.imageProfileHome

        btnNavSend.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sendMoneyFragment2)
        }
        btnNavReceive.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_requestMoneyFragment2)
        }
        imgNavProfile.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_profilePageFragment2)
        }

        // Retorna la raíz del binding
        return binding.root
    }
}
