package com.example.alkewalletm5.login.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingUpViewModel:ViewModel (){
    private val _navigateToLoginPage = MutableLiveData<Boolean>()
    val navigateToLoginPage: LiveData<Boolean>
        get() = _navigateToLoginPage

    init {
        _navigateToLoginPage.value = false
    }

    fun navigateToLoginPage() {
        _navigateToLoginPage.value = true
    }

    fun onLoginPageNavigated() {
        _navigateToLoginPage.value = false
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
}