package com.geekbrains.popularlib.di.components

import com.geekbrains.popularlib.di.modules.*
import com.geekbrains.popularlib.ui.main.MainActivity
import com.geekbrains.popularlib.ui.main.MainPresenter
import com.geekbrains.popularlib.ui.repo_info.RepoInfoPresenterFactory
import com.geekbrains.popularlib.ui.repos.ReposPresenter
import com.geekbrains.popularlib.ui.repos.ReposPresenterFactory
import com.geekbrains.popularlib.ui.users.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CacheModule::class,
        CiceroneModule::class,
        ContextModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun usersPresenter(): UsersPresenter
    fun reposPresenterFactory(): ReposPresenterFactory
    fun repoInfoPresenterFactory(): RepoInfoPresenterFactory
}