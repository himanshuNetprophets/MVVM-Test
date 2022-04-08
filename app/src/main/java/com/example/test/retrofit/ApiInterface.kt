package com.example.test.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("generate_otp")
    fun getGenerateOTP(@Header("Signature") key: String?,
                       @Field("mobile") mobile: String?) : Call<ServicesSetterGetter>

}