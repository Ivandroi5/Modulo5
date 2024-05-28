package com.example.alkewalletm5.home.presentation.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletm5.databinding.TransactionItemBinding
import com.example.alkewalletm5.home.data.local.entities.Transaction

private val TAG = TransactionAdapter::class.java.simpleName

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    lateinit var onItemClickListener: (Transaction) -> Unit

    var transaction = mutableListOf<Transaction>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapter.TransactionViewHolder {

        val bindingItem =
            TransactionItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)

        return TransactionViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: TransactionAdapter.TransactionViewHolder, position: Int) {
        val transaction: Transaction = transaction[position]
        holder.bind(transaction)
    }

    override fun getItemCount(): Int {
        return transaction.size
    }

    inner class TransactionViewHolder(private var bindingItem: TransactionItemBinding) :
        RecyclerView.ViewHolder(bindingItem.root) {

        fun bind(transaction: Transaction) {

            with(transaction) {
                bindingItem.ImageContact.setImageResource(imageContactTransaction)
                bindingItem.nameContact.text = nameContactTransaction.toString()
                bindingItem.dateTransacction.text= dateTransaction.toString()
                bindingItem.amountTransacction.text= amountTransaction.toString()
            }
            bindingItem.root.setOnClickListener {
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(transaction)
                else
                    Log.e(TAG, "onItemClickList is not initialized")

            }

        }
    }

}