package com.geekbrains.popularlib.db.cache

import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IUsersCache {

    fun setUsers(users: List<GithubUserModel> ): Single<List<GithubUserModel>>

    fun getUsers(): Single<List<GithubUserModel>>
}