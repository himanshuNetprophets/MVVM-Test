package com.example.test.service.repository




import com.example.test.service.model.Project
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Call<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>
}