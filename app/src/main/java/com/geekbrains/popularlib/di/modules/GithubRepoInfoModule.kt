package com.geekbrains.popularlib.di.modules

import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.di.scope.RepoInfoScope
import com.geekbrains.popularlib.di.scope.containers.RepoInfoScopeContainer
import dagger.Module

import dagger.Provides

@Module
class GithubRepoInfoModule {
    @RepoInfoScope
    @Provides
    fun scopeContainer(app: App): RepoInfoScopeContainer = app
}