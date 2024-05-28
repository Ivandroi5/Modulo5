package com.example.alkewalletm5.singup.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletm5.databinding.ActivitySingupBinding
import com.example.alkewalletm5.login.presentation.ui.LoginPageActivity
import com.example.alkewalletm5.login.presentation.viewmodel.SingUpViewModel

class SingupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingupBinding
    private lateinit var viewModel: SingUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SingUpViewModel::class.java)

        viewModel.navigateToLoginPage.observe(this, Observer { navigate ->
            if (navigate) {
                startActivity(Intent(this, LoginPageActivity::class.java))
                viewModel.onLoginPageNavigated()
            }
        })

        viewModel.createAccount.observe(this, Observer { create ->
            if (create) {
                val name = binding.textInputLayoutLastName.editText?.text.toString()
                val lastName = binding.textInputLayoutLastName.editText?.text.toString()
                val email = binding.editTextTextEmailAddress.editText?.text.toString()
                val password = binding.editTextTextPassword3.editText?.text.toString()

                viewModel.createAccount(name, lastName, email, password )
            }
            binding.createAccountFinal.setOnClickListener{
                viewModel.navigateToLoginPage()
            }
        })

        binding.loginAccountSingup.setOnClickListener {
            viewModel.navigateToLoginPage()
        }
    }
}

