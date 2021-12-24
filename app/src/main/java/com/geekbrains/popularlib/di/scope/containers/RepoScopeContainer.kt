package com.geekbrains.popularlib.di.scope.containers

import com.geekbrains.popularlib.di.components.GithubRepoSubcomponent

interface RepoScopeContainer {
    fun destroyRepoSubcomponent()
    fun initRepoSubcomponent(): GithubRepoSubcomponent
}