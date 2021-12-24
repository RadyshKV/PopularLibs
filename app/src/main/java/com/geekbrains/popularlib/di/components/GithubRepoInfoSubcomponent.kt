package com.geekbrains.popularlib.di.components

import com.geekbrains.popularlib.di.modules.GithubRepoInfoModule
import com.geekbrains.popularlib.di.scope.RepoInfoScope

import com.geekbrains.popularlib.ui.repo_info.RepoInfoPresenterFactory
import dagger.Subcomponent

@RepoInfoScope
@Subcomponent(
    modules = [
        GithubRepoInfoModule::class,
    ]
)
interface GithubRepoInfoSubcomponent {

    fun repoInfoPresenterFactory(): RepoInfoPresenterFactory

}

