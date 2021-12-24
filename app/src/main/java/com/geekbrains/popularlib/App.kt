package com.geekbrains.popularlib

import android.app.Application
import com.geekbrains.popularlib.di.components.*
import com.geekbrains.popularlib.di.modules.AppModule
import com.geekbrains.popularlib.di.scope.containers.RepoInfoScopeContainer
import com.geekbrains.popularlib.di.scope.containers.RepoScopeContainer
import com.geekbrains.popularlib.di.scope.containers.UsersScopeContainer

class App: Application(), UsersScopeContainer, RepoScopeContainer, RepoInfoScopeContainer {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    var usersSubcomponent: GithubUsersSubcomponent? = null

    var repoSubcomponent: GithubRepoSubcomponent? = null

    var repoInfoSubcomponent: GithubRepoInfoSubcomponent? = null


    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    override fun initUsersSubcomponent() = appComponent.userSubcomponent().also {
        usersSubcomponent = it
    }

    override fun destroyUsersSubcomponent() {
        usersSubcomponent = null
    }

    override fun initRepoSubcomponent() = appComponent.userSubcomponent().repoSubcomponent().also {
        repoSubcomponent = it
    }

    override fun destroyRepoSubcomponent() {
        repoSubcomponent = null
    }

    override fun destroyRepoInfoSubcomponent() {
        repoInfoSubcomponent = null
    }

    override fun initRepoInfoSubcomponent() = appComponent.userSubcomponent().repoSubcomponent().repoInfoSubcomponent().also {
        repoInfoSubcomponent = it
    }

    companion object{
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}