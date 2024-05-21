package com.example.alkewalletm5.login.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletm5.R
import com.example.alkewalletm5.databinding.ActivityIntroAccountBinding
import com.example.alkewalletm5.login.presentation.viewmodel.IntroActivityViewModel
import com.example.alkewalletm5.singup.presentation.ui.SingupActivity

class IntroAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroAccountBinding

    private lateinit var viewModel: IntroActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro_account)
        binding = ActivityIntroAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(IntroActivityViewModel::class.java)

        viewModel.navigateToSingUpPage.observe(this, Observer { navigate ->
            if (navigate) {
                startActivity(Intent(this, SingupActivity::class.java))
                viewModel.onSingUpPageNavigated()
            }
        })

        binding.createAccountButton.setOnClickListener {
            viewModel.navigateToSingUpPage()
        }
        viewModel.navigateToLoginPage.observe(this, Observer { navigate ->
            if (navigate) {
                startActivity(Intent(this, LoginPageActivity::class.java))
                viewModel.onLoginPageNavigated()
            }
        })
        binding.userAccessLink.setOnClickListener {
            viewModel.navigateToLoginPage()
        }
    }

}

