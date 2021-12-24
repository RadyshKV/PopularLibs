package com.geekbrains.popularlib.di.components

import com.geekbrains.popularlib.di.modules.GithubUserModule
import com.geekbrains.popularlib.di.scope.UsersScope
import com.geekbrains.popularlib.ui.users.UsersPresenter
import dagger.Subcomponent

@UsersScope
@Subcomponent(
    modules = [
        GithubUserModule::class,
    ]
)
interface GithubUsersSubcomponent {

    fun repoSubcomponent(): GithubRepoSubcomponent

    fun usersPresenter(): UsersPresenter
}