package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.db.cache.IRepositoriesCache
import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.remote.RetrofitService
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GithubReposRepositoryImpl @Inject constructor(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val reposCache: IRepositoriesCache,
) : GithubReposRepository {

    override fun getRepos(userModel: GithubUserModel): Single<List<GithubRepoModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getRepos(userModel.reposUrl)
                .flatMap { repos -> reposCache.setRepos(repos)}
        } else {
            reposCache.getRepos(userModel)
        }
    }
}