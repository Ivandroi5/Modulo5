package com.example.alkewalletm5.login.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletm5.R
import com.example.alkewalletm5.databinding.ActivityLoginPageBinding
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

        viewModel =ViewModelProvider(this).get(LoginPageViewModel::class.java)

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