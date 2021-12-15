package com.geekbrains.popularlib.db.cache

import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IRepositoriesCache {

    fun setRepos(repos: List<GithubRepoModel>): Single<List<GithubRepoModel>>

    fun getRepos(userModel: GithubUserModel): Single<List<GithubRepoModel>>
}