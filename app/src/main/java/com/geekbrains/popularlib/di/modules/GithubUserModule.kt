package com.geekbrains.popularlib.di.modules


import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.db.cache.IUsersCache
import com.geekbrains.popularlib.db.cache.RoomGithubUsersCache
import com.geekbrains.popularlib.di.scope.UsersScope
import com.geekbrains.popularlib.di.scope.containers.UsersScopeContainer
import com.geekbrains.popularlib.domain.GithubUsersRepository
import com.geekbrains.popularlib.domain.GithubUsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GithubUserModule {

    @UsersScope
    @Binds
    abstract fun bindsUsersRepository (impl: GithubUsersRepositoryImpl): GithubUsersRepository

    @UsersScope
    @Binds
    abstract fun usersCache(impl: RoomGithubUsersCache): IUsersCache

    companion object{

        @UsersScope
        @Provides
        fun scopeContainer(app: App): UsersScopeContainer = app
    }
}