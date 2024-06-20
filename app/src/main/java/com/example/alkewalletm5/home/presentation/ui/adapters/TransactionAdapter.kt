package com.example.alkewalletm5.home.presentation.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletm5.databinding.TransactionItemBinding
import com.example.alkewalletm5.data.local.entities.Transaction

private val TAG = TransactionAdapter::class.java.simpleName

/**
 * Clase que se encarga de mostrar la lista de transacciones
 * @param transaction lista de transacciones
 * @param onItemClickListener variable que recibe una transacción
 */

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    lateinit var onItemClickListener: (Transaction) -> Unit

    var transaction = mutableListOf<Transaction>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     *  Crea el viewholder
     *  @param bindingItem el binding que infla el layout que pinta el recyclerview
     *  @param return retorna el viewHolder de la transacci
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapter.TransactionViewHolder {

        val bindingItem =
            TransactionItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)

        return TransactionViewHolder(bindingItem)
    }

    /**
     * @param position la transaccion del perfil en la lista
     */
    override fun onBindViewHolder(holder: TransactionAdapter.TransactionViewHolder, position: Int) {
        val transaction: Transaction = transaction[position]
        holder.bind(transaction)
    }

    /**
     *  @return la cantidad de transacciones en la lista
     */
    override fun getItemCount(): Int {
        return transaction.size
    }

    /**
     * Clase viewholder que pinta el fragment de transacciones de un usuario
     *
     */

    inner class TransactionViewHolder(private var bindingItem: TransactionItemBinding) :
        RecyclerView.ViewHolder(bindingItem.root) {

        /**
         * Pinta los datos del xml con los datos del perfil
         * @param transaction muestra el detalle de la transaccion
         */


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