package com.example.test.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.example.test.model.User
import com.example.test.retrofit.MainActivityRepository
import com.example.test.retrofit.ServicesSetterGetter
import com.example.test.util.SingleLiveEvent
import com.example.test.util.Util


class LoginViewModel(val context: Context) : ViewModel() {


    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var progressDialog: SingleLiveEvent<Boolean>? = null
    var userLogin: MutableLiveData<User>? = null

    init {
        btnSelected = ObservableBoolean(false)
        progressDialog = SingleLiveEvent<Boolean>()
        email = ObservableField("")
        password = ObservableField("")
        userLogin = MutableLiveData<User>()
    }

    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(s.toString()) && password?.get()!!.length >= 8)


    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(email?.get()!!) && s.toString().length >= 8)


    }
    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = MutableLiveData<ServicesSetterGetter>()

    fun getUser() : LiveData<ServicesSetterGetter>? {
//        if(!Util.isEmailValid(email?.get()!!)){
//            Toast.makeText(context,"Please Enter Valid Email Id",Toast.LENGTH_LONG).show()
//        } else if (password?.get()!!.length < 8){
//            Toast.makeText(context,"Please Enter Valid Password",Toast.LENGTH_LONG).show()
//        } else {
            servicesLiveData = MainActivityRepository.getServicesApiCall("1GyU75Qt3xPpvK17pPeC7w==","1GyU75Qt3xPpvK17pPeC7w")
            return servicesLiveData
//        }
////        servicesLiveData = MainActivityRepository.getServicesApiCall()
//        return servicesLiveData

    }


    fun login() {
        if(!Util.isEmailValid(email?.get()!!)){
            Toast.makeText(context,"Please Enter Valid Email Id",Toast.LENGTH_LONG).show()
        } else if (password?.get()!!.length < 8){
            Toast.makeText(context,"Please Enter Valid Password",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context,"1",Toast.LENGTH_LONG).show()
//            servicesLiveData = MainActivityRepository.getServicesApiCall()
        }
    }
    override fun onCleared() {
        super.onCleared()
    }

    class Factory(val context: Context) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return LoginViewModel(context) as T
        }
    }


}




