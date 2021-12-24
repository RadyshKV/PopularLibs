package com.geekbrains.popularlib.di.scope.containers

import com.geekbrains.popularlib.di.components.GithubRepoInfoSubcomponent

interface RepoInfoScopeContainer {

    fun destroyRepoInfoSubcomponent()
    fun initRepoInfoSubcomponent(): GithubRepoInfoSubcomponent
}



