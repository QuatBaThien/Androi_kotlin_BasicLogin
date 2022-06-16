package com.example.loginactivity.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(application)!!.userDao()
        repository = UserRepository(userDao)
    }
    fun addUser(users: Users){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(users)
        }

    }

}