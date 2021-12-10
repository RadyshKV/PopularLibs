package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.remote.RetrofitService
import io.reactivex.rxjava3.core.Single


class GithubReposRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubReposRepository {

    override fun getRepos(reposUrl: String): Single<List<GithubRepoModel>> {
        return retrofitService.getRepos(reposUrl)
    }
}