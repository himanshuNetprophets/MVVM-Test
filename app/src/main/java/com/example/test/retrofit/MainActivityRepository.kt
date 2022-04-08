package com.example.test.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(mobile: String,key: String): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getGenerateOTP(key,mobile)

        call.enqueue(object: Callback<ServicesSetterGetter> {
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
                serviceSetterGetter.value = ServicesSetterGetter("vgsdfgsdg")
            }

            override fun onResponse(
                call: Call<ServicesSetterGetter>,
                response: Response<ServicesSetterGetter>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

//                val msg = data!!.message


                serviceSetterGetter.value = ServicesSetterGetter("vgsdfgsdg")
            }
        })

        return serviceSetterGetter
    }
}