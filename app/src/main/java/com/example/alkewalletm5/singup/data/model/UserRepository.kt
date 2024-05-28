package com.example.alkewalletm5.login.data.model

import LoginUser
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository {
        private val _userAdded = MutableLiveData<LoginUser>()
        val userAdded: LiveData<LoginUser>
            get() = _userAdded

        private val registeredUsers = mutableListOf<LoginUser>()

        fun addUser(user: LoginUser) {
            registeredUsers.add(user)
            _userAdded.value = user
        }
    fun getUserByEmail(email: String): LoginUser? {
        return registeredUsers.find { it.email == email }

    }
    fun getUserByEmailAndPassword(email: String, password: String): LoginUser? {
        return registeredUsers.find { it.email == email && it.password == password }
    }
    }