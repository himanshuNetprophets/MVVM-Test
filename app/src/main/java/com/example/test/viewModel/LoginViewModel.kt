package com.example.test.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private var mCtx: Context? = null



    fun login(){
        mCtx = this.mCtx;
       Log.e("Login","Login Done")
        Toast.makeText(mCtx!!.applicationContext,"Login Done",Toast.LENGTH_LONG).show()

    }
}