package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubReposRepository {

    fun getRepos(userModel: GithubUserModel): Single<List<GithubRepoModel>>
}
