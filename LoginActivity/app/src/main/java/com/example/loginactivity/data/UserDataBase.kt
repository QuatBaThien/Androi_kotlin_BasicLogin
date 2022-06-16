package com.example.loginactivity.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userDao(): UsersDao
    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDatabase(context:Context): UserDataBase? {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                "user.db").build()
                INSTANCE = instance
                return instance
        }
    }
}