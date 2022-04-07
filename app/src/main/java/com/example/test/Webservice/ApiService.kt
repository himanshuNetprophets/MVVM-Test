package com.example.test.Webservice

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Header("X-Api-Key") key: String?,
        @Field("mobile_or_email") mobile_or_email: String?,
        @Field("password") password: String?
    ): Call<AuthBeanModel?>?

    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>
}