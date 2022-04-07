package com.example.test.callback

import android.view.View

interface LoginActivityCallback {
    fun onLoginClick(view: View)
    fun onRegisterClick(view: View)
}