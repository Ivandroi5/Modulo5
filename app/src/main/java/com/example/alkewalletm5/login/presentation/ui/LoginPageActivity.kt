package com.example.alkewalletm5.login.presentation.ui

import LoginUser
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletm5.R
import com.example.alkewalletm5.databinding.ActivityLoginPageBinding
import com.example.alkewalletm5.home.presentation.ui.HomeNavigationActivity
import com.example.alkewalletm5.login.presentation.viewmodel.LoginPageViewModel
import com.example.alkewalletm5.singup.presentation.ui.SingupActivity

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var viewModel: LoginPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Recuperar el objeto User pasado desde la actividad de registro
        val user = intent.getParcelableExtra<LoginUser>("user")

        viewModel = ViewModelProvider(this).get(LoginPageViewModel::class.java)

        binding.loginAccountButton.setOnClickListener {
            val email = binding.enterEmailLogin.text.toString()
            val password = binding.enterPasswordLogin.text.toString()

            if (viewModel.validateCredentials(email, password)) {
                Toast.makeText(this, "Accediendo...", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, HomeNavigationActivity::class.java))
                viewModel.onHomeNavigated()


            } else {
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