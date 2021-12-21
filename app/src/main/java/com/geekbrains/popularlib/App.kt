package com.geekbrains.popularlib

import android.app.Application
import com.geekbrains.popularlib.di.components.AppComponent
import com.geekbrains.popularlib.di.components.DaggerAppComponent
import com.geekbrains.popularlib.di.modules.ContextModule

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }
    companion object{
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}