package com.geekbrains.popularlib.di.modules

import com.geekbrains.popularlib.domain.GithubReposRepository
import com.geekbrains.popularlib.domain.GithubReposRepositoryImpl
import com.geekbrains.popularlib.domain.GithubUsersRepository
import com.geekbrains.popularlib.domain.GithubUsersRepositoryImpl

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsUsersRepo (impl: GithubUsersRepositoryImpl): GithubUsersRepository

    @Singleton
    @Binds
    abstract fun bindsReposRepo (impl: GithubReposRepositoryImpl): GithubReposRepository

}