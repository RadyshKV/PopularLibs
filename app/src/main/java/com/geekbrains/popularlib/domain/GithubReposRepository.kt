package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubRepoModel
import io.reactivex.rxjava3.core.Single

interface GithubReposRepository {

    fun getRepos(reposUrl: String): Single<List<GithubRepoModel>>
}
