package com.geekbrains.popularlib.ui.user_info


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserInfoPresenter(
    private val router: Router,
) : MvpPresenter<UserInfoView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setLogin()
    }

    private fun setLogin() {
        viewState.setLogin("AnyText")
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}