package com.geekbrains.popularlib.ui.main

import com.geekbrains.popularlib.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(AppScreens.usersScreen())
    }

    fun backPressed(){
        router.exit()
    }
}