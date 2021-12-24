package com.geekbrains.popularlib.di.modules

import android.app.Application
import android.content.Context
import com.geekbrains.popularlib.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun context(): Context {
        return app
    }

    @Singleton
    @Provides
    fun app(): App {
        return app
    }
}