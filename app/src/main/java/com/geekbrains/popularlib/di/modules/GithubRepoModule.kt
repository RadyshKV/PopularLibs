package com.geekbrains.popularlib.di.modules

import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.db.cache.IRepositoriesCache
import com.geekbrains.popularlib.db.cache.RoomGithubRepositoriesCache
import com.geekbrains.popularlib.di.scope.RepoScope
import com.geekbrains.popularlib.di.scope.containers.RepoScopeContainer
import com.geekbrains.popularlib.domain.GithubReposRepository
import com.geekbrains.popularlib.domain.GithubReposRepositoryImpl

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GithubRepoModule {

    @RepoScope
    @Binds
    abstract fun bindsReposRepository (impl: GithubReposRepositoryImpl): GithubReposRepository

    @RepoScope
    @Binds
    abstract fun bindsReposCache(impl: RoomGithubRepositoriesCache): IRepositoriesCache

    companion object{
        @RepoScope
        @Provides
        fun scopeContainer(app: App): RepoScopeContainer = app
    }
}