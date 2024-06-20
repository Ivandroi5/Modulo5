package com.example.alkewalletm5.login.presentation.viewmodel

import android.app.Application
import com.example.alkewalletm5.data.model.LoginUser
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletm5.R

/**
 * ViewModel para la pantalla de registro quue navega hacia la pantalla de acceso
 */
class SingupViewModel : ViewModel() {
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

    /**
     * Función para traer los daotos escuchados en los campos de registro y asignarle variables nuevas
     * y finalmente agregarlis a la lista de usuarios
     * @param userId es el id del usuario creado para facilitar su movimiento en la app
     * @param balance es el saldo inicial del usuario
     * @param imageProfile es la imagen de perfil por defecto
     */
    fun createAccount(name: String, lastName: String, email: String, password: String): LoginUser {

         val newUser = LoginUser(userId = 0, name = name, lastName = lastName, email = email, password = password,
             balance =100.00, imageProfile = R.drawable.default_profile_image)
        LoginUser.dataLoginUsers.add(newUser)

        // Después de crear la cuenta, navega a la página de inicio de sesión
        _createAccount.value = true
        _navigateToLoginPage.value = true
        return newUser
    }
}