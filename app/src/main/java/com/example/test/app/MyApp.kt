package com.example.test.app


import android.app.Application
import androidx.room.Room
import com.example.test.service.room.UserDatabase

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        MyApp.database= Room.databaseBuilder(this, UserDatabase::class.java, "users.db").allowMainThreadQueries().build()
    }
    companion object {
        lateinit var database:  UserDatabase
    }
}