package com.example.test.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.test.Webservice.ApiClient
import com.example.test.Webservice.AuthBeanModel
import com.example.test.model.User
import com.example.test.util.SingleLiveEvent
import com.example.test.util.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(application: Application) : AndroidViewModel(application), Callback<User> {


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

    fun login() {
        if(!Util.isEmailValid(email?.get()!!)){
            Toast.makeText(getApplication(),"Please Enter Valid Email Id",Toast.LENGTH_LONG).show()
        } else if (password?.get()!!.length < 8){
            Toast.makeText(getApplication(),"Please Enter Valid Password",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(getApplication(),"Login Done",Toast.LENGTH_LONG).show()

//            WebServiceClient.client.create(BackEndApi::class.java).LOGIN(email = email?.get()!!
//                , password = password?.get()!!)
//                .enqueue(this)

            ApiClient.apiService.login("admin@1234", "login.getEmail()", "login.getPassword()")
                .enqueue(object : Callback<AuthBeanModel> {
                    override fun onResponse(
                        call: Call<AuthBeanModel>,
                        response: Response<AuthBeanModel>) {
                        Toast.makeText(getApplication(),"fsdfsd",Toast.LENGTH_LONG).show()
//                        if (response.body().getStatus()) {
//
//                        } else {
//
//                        }
                    }

                    override fun onFailure(call: Call<AuthBeanModel>, t: Throwable) {
                        Toast.makeText(getApplication(),"fsdfsd",Toast.LENGTH_LONG).show()
                    }
                })

        }



    }

    override fun onResponse(call: Call<User>?, response: Response<User>?) {
        progressDialog?.value = false
        userLogin?.value = response?.body()

    }

    override fun onFailure(call: Call<User>?, t: Throwable?) {
        progressDialog?.value = false

    }
    fun <T> Call<T>?.enqueue(callback: Callback<AuthBeanModel>) {
        Toast.makeText(getApplication(),callback.toString(),Toast.LENGTH_LONG).show()
    }

}




