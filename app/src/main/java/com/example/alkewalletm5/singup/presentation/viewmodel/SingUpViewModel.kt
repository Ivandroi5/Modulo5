package com.example.alkewalletm5.login.presentation.viewmodel

import LoginUser
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletm5.R

class SingUpViewModel : ViewModel() {
    private val _navigateToLoginPage = MutableLiveData<Boolean>()
    val navigateToLoginPage: LiveData<Boolean>
        get() = _navigateToLoginPage

    private val _createAccount = MutableLiveData<Boolean>()
    val createAccount: LiveData<Boolean>
        get() = _createAccount

    init {
        _navigateToLoginPage.value = false
        _createAccount.value = false
    }

    fun navigateToLoginPage() {
        _navigateToLoginPage.value = true
    }

    fun onLoginPageNavigated() {
        _navigateToLoginPage.value = false
    }

    fun createAccount(name: String, lastName: String, email: String, password: String) {
        // Aquí puedes realizar la lógica para crear la cuenta con los datos proporcionados
        // Por ejemplo:
         val newUser = LoginUser(name, lastName, email, password,
             balance =100.00, imageProfile = R.drawable.default_profile_image)
        LoginUser.dataLoginUsers.add(newUser)

        // Después de crear la cuenta, navega a la página de inicio de sesión
        _createAccount.value = true
    }
}