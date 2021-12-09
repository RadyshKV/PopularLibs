package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.remote.RetrofitService
import io.reactivex.rxjava3.core.Single


class GithubUsersRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return retrofitService.getUsers()
    }
}