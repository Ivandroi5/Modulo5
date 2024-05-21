package com.example.alkewalletm5.login.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


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
}