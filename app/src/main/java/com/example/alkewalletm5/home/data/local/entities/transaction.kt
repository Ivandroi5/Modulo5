package com.example.alkewalletm5.home.data.local.entities

import com.example.alkewalletm5.R

data class Transaction (
    val id: String,
    var imageContactTransaction: Int = 0,
    val nameContactTransaction: String,
    val dateTransaction: String,
    val amountTransaction: String,
    ) {
    companion object {
        val datatransaction = mutableListOf<Transaction>(
        Transaction("1",R.drawable.yara, "Yara Kalil",
        "OCT 14, 10:24","-$15.00"),
        Transaction("2",R.drawable.sara, "Sara Ibrahim",
        "OCT 12, 02:13","+$20.50"),
        Transaction("3",R.drawable.ahmad, "Ahmad Ibrahim",
        "OCT 11, 01:19","+12.40"),
        Transaction("4",R.drawable.reem, "Reem Khaled",
        "OCT 07, 09:10","-$21.30"),
        Transaction("5",R.drawable.hiba, "Hiba Saleh",
        "OCT 04, 5:45","-$09.00"),
            )
        val dataTransactionEmpty = mutableListOf<Transaction>()
    }
}
