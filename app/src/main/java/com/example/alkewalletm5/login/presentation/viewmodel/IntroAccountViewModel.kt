package com.example.alkewalletm5.login.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class IntroActivityViewModel : ViewModel() {

    //Para ir a la página de registrar cuenta

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

    //Para ir a la pagina de acceso a usuarios

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
}