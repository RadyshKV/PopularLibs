package com.geekbrains.popularlib.di.modules

import com.geekbrains.popularlib.navigation.AppScreens
import com.geekbrains.popularlib.navigation.AppScreensImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {
    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    @Singleton
    @Provides
    fun navigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Singleton
    @Provides
    fun router(): Router {
        return cicerone.router
    }

    @Singleton
    @Provides
    fun appScreens(): AppScreens {
        return AppScreensImpl()
    }
}