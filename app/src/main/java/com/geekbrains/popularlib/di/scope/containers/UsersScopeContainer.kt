package com.geekbrains.popularlib.di.scope.containers

import com.geekbrains.popularlib.di.components.GithubUsersSubcomponent

interface UsersScopeContainer {
    fun destroyUsersSubcomponent()
    fun initUsersSubcomponent(): GithubUsersSubcomponent

}