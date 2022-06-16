package com.example.loginactivity.data

import androidx.lifecycle.LiveData

class UserRepository(private val usersDao: UsersDao){
    suspend fun addUser(users: Users){
        usersDao.addUser(users)
    }
}