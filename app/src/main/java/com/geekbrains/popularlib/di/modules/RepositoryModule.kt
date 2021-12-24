package com.geekbrains.popularlib.di.modules

import com.geekbrains.popularlib.db.cache.IRepositoriesCache
import com.geekbrains.popularlib.db.cache.IUsersCache
import com.geekbrains.popularlib.domain.GithubReposRepository
import com.geekbrains.popularlib.domain.GithubReposRepositoryImpl
import com.geekbrains.popularlib.domain.GithubUsersRepository
import com.geekbrains.popularlib.domain.GithubUsersRepositoryImpl
import com.geekbrains.popularlib.remote.RetrofitService
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun usersRepo(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        usersCache: IUsersCache
    ):GithubUsersRepository{
        return GithubUsersRepositoryImpl(networkStatus, retrofitService, usersCache)
    }

    @Provides
    fun reposRepo(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        reposCache: IRepositoriesCache
    ): GithubReposRepository {
        return GithubReposRepositoryImpl(networkStatus, retrofitService, reposCache)
    }
}