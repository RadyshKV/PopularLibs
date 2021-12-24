package com.geekbrains.popularlib.di.components

import com.geekbrains.popularlib.di.modules.*
import com.geekbrains.popularlib.ui.main.MainActivity
import com.geekbrains.popularlib.ui.main.MainPresenter
import com.geekbrains.popularlib.ui.repo_info.RepoInfoPresenterFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        CiceroneModule::class,
        AppModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun mainPresenter(): MainPresenter

    fun userSubcomponent(): GithubUsersSubcomponent

}