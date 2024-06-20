package com.example.alkewalletm5.home.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkewalletm5.R
import com.example.alkewalletm5.databinding.FragmentHomeBinding
import com.example.alkewalletm5.data.local.entities.Transaction
import com.example.alkewalletm5.home.presentation.ui.adapters.ProfileAdapter
import com.example.alkewalletm5.home.presentation.ui.adapters.TransactionAdapter
import com.example.alkewalletm5.data.local.entities.Profile

/**
 * Fragmento para la página principal del Home del usuario
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    /**
     * Método para crear la vista del fragmento usa acciones de navigation graph
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val btnNavSend: Button = binding.travelToSendMoney
        val btnNavReceive: Button = binding.travelToReceiveMoney


        btnNavSend.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sendMoneyFragment2)
        }
        btnNavReceive.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_requestMoneyFragment2)
        }

        binding.recyclerViewTransaction.layoutManager = LinearLayoutManager(requireContext())
        binding.frameLayoutInfoProfile.layoutManager = LinearLayoutManager(requireContext())

       // val userId = 1
        //val user = com.example.alkewalletm5.data.model.LoginUser.dataLoginUsers.find { it.userId == userId }


        initAdapterTransaction()
        initAdapterProfile()

        return binding.root
    }

    /**
     * Métodos para inicializar los adapters de transacciones y perfiles
     */
    fun initAdapterTransaction() {
        val transactionAdapter = TransactionAdapter()
        binding.recyclerViewTransaction.adapter = transactionAdapter


        transactionAdapter.transaction = Transaction.datatransaction
        //transactionAdapter.transaction = Transaction.dataTransactionEmpty
        transactionAdapter.onItemClickListener = { transaction ->
            Toast.makeText(requireContext(), transaction.dateTransaction, Toast.LENGTH_SHORT).show()

        }

        if (transactionAdapter.transaction.isEmpty()) {
            binding.imageNoTransaction.visibility = View.VISIBLE
            binding.textNoTransaction.visibility = View.VISIBLE
        } else {
            binding.imageNoTransaction.visibility = View.GONE
            binding.textNoTransaction.visibility = View.GONE
        }
    }

    fun initAdapterProfile() {
        val profileAdapter = ProfileAdapter()
        binding.frameLayoutInfoProfile.adapter = profileAdapter

        profileAdapter.profiles = Profile.dataProfiles
        profileAdapter.onItemClickListener = { profile ->
            Toast.makeText(
                requireContext(), "Navegando hacia el perfil de ${profile.name}",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_homeFragment_to_profilePageFragment2)

        }
        if (profileAdapter.profiles.isEmpty()) {
            binding.noProfile.visibility = View.VISIBLE

        } else {
            binding.noProfile.visibility = View.GONE

        }
    }
}