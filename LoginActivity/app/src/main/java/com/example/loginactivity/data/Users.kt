package com.example.loginactivity.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="EmailAddress") val EmailAddress: String,
    @ColumnInfo(name = "Password") val Password: String
)
