package com.example.alkewalletm5.login.presentation.ui

import LoginUser
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletm5.databinding.ActivityLoginPageBinding
import com.example.alkewalletm5.home.presentation.ui.HomeNavigationActivity
import com.example.alkewalletm5.login.presentation.viewmodel.LoginPageViewModel
import com.example.alkewalletm5.singup.presentation.ui.SingupActivity

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var viewModel: LoginPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginPageViewModel::class.java)

        // Recibir datos del usuario recién creado desde SingupActivity
        val newUser = intent.getParcelableExtra<LoginUser>("newUser")

        // Validar el usuario recién creado
        if (newUser != null) {
            if (viewModel.validateCredentials(newUser.email, newUser.password)) {
                // Inicio de sesión exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                // Aquí puedes realizar acciones adicionales después de un inicio de sesión exitoso
            } else {
                // Inicio de sesión fallido
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.loginAccountButton.setOnClickListener {
            val email = binding.enterEmailLogin.text.toString()
            val password = binding.enterPasswordLogin.text.toString()

            if (viewModel.validateCredentials(email, password)) {
                // Inicio de sesión exitoso
                Toast.makeText(this, "Accediendo...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeNavigationActivity::class.java))
                viewModel.onHomeNavigated()
            } else {
                // Inicio de sesión fallido
                Log.i("Loginnewuser for else", newUser.toString())

                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.navigateToSingUpPage.observe(this, Observer { navigate ->
            if (navigate) {
                startActivity(Intent(this, SingupActivity::class.java))
                viewModel.onSingUpPageNavigated()
            }
        })

        binding.createAccountLinkLogin.setOnClickListener {
            viewModel.navigateToSingUpPage()
        }
    }
}