package com.example.alkewalletm5.login.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
/**
 * Uso de viewModel para manejar la futura navegación entre pantallas hacia la página de registro y
 * el Home
 */

class LoginPageViewModel: ViewModel() {
    private val _navigateToSingUpPage = MutableLiveData<Boolean>()
    val navigateToSingUpPage: LiveData<Boolean>
        get() = _navigateToSingUpPage

    init {
        _navigateToSingUpPage.value = false
    }

    fun navigateToSingUpPage() {
        _navigateToSingUpPage.value = true
    }
    fun onSingUpPageNavigated() {
        _navigateToSingUpPage.value = false

    }
    private val _navigateToHome = MutableLiveData<Boolean>()


    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome

    init {
        _navigateToHome.value = false
    }

    fun navigateToHome() {
        _navigateToHome.value = true
    }

    fun onHomeNavigated() {
        _navigateToHome.value = false
    }

    /**
     * Función para validar al usuario con la data de usuarios en la data class
     */
    fun validateCredentials(email: String, password: String): Boolean {
        val registeredUsers = LoginUser.dataLoginUsers
        val user = registeredUsers.find { it.email == email && it.password == password }
        return user != null
    }
}