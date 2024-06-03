package com.example.alkewalletm5.singup.presentation.ui

import LoginUser
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletm5.databinding.ActivitySingupBinding
import com.example.alkewalletm5.login.presentation.ui.LoginPageActivity
import com.example.alkewalletm5.login.presentation.viewmodel.SingUpViewModel

/**
 * Actividad reesponsable de la creación de una nueva cuenta
 */
class SingupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingupBinding
    private lateinit var viewModel: SingUpViewModel
    //lateinit var send_button : Button

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
        /**
         * Observar el LiveData createAccount para crear la cuenta y mandarla a LoginPageActivity a
         * través de un intent
         */
        viewModel.createAccount.observe(this, Observer { create ->
            if (create) {
                val name = binding.textInputLayoutLastName.editText?.text.toString()
                val lastName = binding.textInputLayoutLastName.editText?.text.toString()
                val email = binding.editTextTextEmailAddress.editText?.text.toString()
                val password = binding.editTextTextPassword3.editText?.text.toString()


                viewModel.createAccount(name = name, lastName = lastName, email = email, password = password)

                // Configurar el intent para incluir newUser como extra
                val newUser = LoginUser(userId = 0, name = name, lastName = lastName, email= email, password = password)

                // obtener newUser del ViewModel
                val intent = Intent(this, LoginPageActivity::class.java).apply {
                    putExtra("newUser", newUser)
                }
                startActivity(intent)


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