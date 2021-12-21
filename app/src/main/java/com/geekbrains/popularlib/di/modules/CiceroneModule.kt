package com.geekbrains.popularlib.di.modules

import com.geekbrains.popularlib.navigation.AppScreens
import com.geekbrains.popularlib.navigation.AppScreensImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class CiceroneModule {
    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    @Provides
    fun navigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    fun router(): Router {
        return cicerone.router
    }

    @Provides
    fun appScreens(): AppScreens {
        return AppScreensImpl()
    }
}