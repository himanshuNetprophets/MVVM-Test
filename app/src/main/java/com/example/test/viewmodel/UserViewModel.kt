package com.example.test.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test.service.model.User
import com.example.test.service.repository.UserRepository


class UserViewModel(val context: Context): ViewModel() {

    fun loginUser(email: String, password: String) {
//        return UserRepository.getInstance(context).login(email, password)
        Toast.makeText(context,"fsdf",Toast.LENGTH_LONG).show()
    }


    fun registerUser(user: User): LiveData<User>{
        return UserRepository.getInstance(context).register(user)
    }

    override fun onCleared() {
        super.onCleared()
    }

    class Factory(val context: Context) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return UserViewModel(context) as T
        }
    }
}