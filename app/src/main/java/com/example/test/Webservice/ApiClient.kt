package com.example.test.Webservice

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val BASE_URL = "http://soccer.zobofy.com/api/"
    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return retrofit
        }
    val apiService: ApiService
        get() = client!!.create(ApiService::class.java)
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS).build() /*private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String token = app.getToken();
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(request);
        }
    }).build();*/
}
//const val BASEURL = "https://jsonplaceholder.typicode.com/"
//class ApiClient {
//    companion object{
//        private var retrofit:Retrofit?=null
//        fun getApiClient(): Retrofit {
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()
//            val okHttpClient = OkHttpClient.Builder()
//                .readTimeout(100, TimeUnit.SECONDS)
//                .connectTimeout(100, TimeUnit.SECONDS)
//                .build()
//            if (retrofit == null) {
//                retrofit = Retrofit.Builder()
//                    .baseUrl(BASEURL)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build()
//            }
//            return retrofit!!
//        }
//    }
//}