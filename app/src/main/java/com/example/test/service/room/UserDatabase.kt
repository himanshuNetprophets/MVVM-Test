package com.example.test.service.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.service.model.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}