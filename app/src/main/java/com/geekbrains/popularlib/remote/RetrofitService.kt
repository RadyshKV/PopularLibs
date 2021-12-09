package com.geekbrains.popularlib.remote

import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>
}