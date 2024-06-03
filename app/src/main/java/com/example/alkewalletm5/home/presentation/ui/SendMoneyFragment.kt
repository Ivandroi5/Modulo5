package com.example.alkewalletm5.home.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkewalletm5.R
import com.example.alkewalletm5.databinding.FragmentSendMoneyBinding

/**
 * Fragment para enviar dinero llevala navegación para volver al Home
 */

class SendMoneyFragment : Fragment() {

    private lateinit var binding: FragmentSendMoneyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        val btnNavSendMoney = binding.buttonSendMoney
        val btnNavBackHome2 = binding.backArrowSendMoney

        btnNavSendMoney.setOnClickListener {
            //hacer lógica de envío
            findNavController().navigate(R.id.action_sendMoneyFragment2_to_homeFragment)
        }
        btnNavBackHome2.setOnClickListener {
            findNavController().navigate(R.id.action_sendMoneyFragment2_to_homeFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}
