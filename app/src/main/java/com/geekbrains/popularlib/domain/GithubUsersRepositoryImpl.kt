package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.db.cache.IUsersCache
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.remote.RetrofitService
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GithubUsersRepositoryImpl @Inject constructor(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val usersCache: IUsersCache,
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getUsers()
                .flatMap { users -> usersCache.setUsers(users)}
        } else {
            usersCache.getUsers()
        }
    }
}