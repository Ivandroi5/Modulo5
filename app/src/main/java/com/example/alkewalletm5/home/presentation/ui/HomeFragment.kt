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
import com.example.alkewalletm5.home.data.local.entities.Transaction
import com.example.alkewalletm5.home.presentation.ui.adapters.TransactionAdapter
import com.google.android.material.imageview.ShapeableImageView


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val btnNavSend: Button = binding.travelToSendMoney
        val btnNavReceive: Button = binding.travelToReceiveMoney
        val imgNavProfile: ShapeableImageView = binding.imageProfileHome

        btnNavSend.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sendMoneyFragment2)
        }
        btnNavReceive.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_requestMoneyFragment2)
        }
        imgNavProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profilePageFragment2)
        }
        binding.recyclerViewTransaction.layoutManager = LinearLayoutManager(requireContext())

        initAdapter()

        // Retorna la raíz del binding
        return binding.root
    }

    fun initAdapter() {
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
}
