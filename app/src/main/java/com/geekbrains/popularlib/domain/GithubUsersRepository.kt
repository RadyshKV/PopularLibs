package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>
}
