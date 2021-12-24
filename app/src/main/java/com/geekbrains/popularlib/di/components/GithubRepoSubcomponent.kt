package com.geekbrains.popularlib.di.components

import com.geekbrains.popularlib.di.modules.GithubRepoModule
import com.geekbrains.popularlib.di.scope.RepoScope
import com.geekbrains.popularlib.ui.repos.ReposPresenterFactory
import dagger.Subcomponent

@RepoScope
@Subcomponent(
    modules = [
        GithubRepoModule::class,
    ]
)
interface GithubRepoSubcomponent {

    fun repoInfoSubcomponent(): GithubRepoInfoSubcomponent

    fun reposPresenterFactory(): ReposPresenterFactory
}