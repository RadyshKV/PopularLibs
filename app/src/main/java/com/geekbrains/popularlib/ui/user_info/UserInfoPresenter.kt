package com.geekbrains.popularlib.ui.user_info


import android.os.Bundle
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserInfoPresenter(
    private val router: Router,
) : MvpPresenter<UserInfoView>() {

    private var userLogin: String = "User"

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setLogin()
    }

    private fun setLogin() {
        viewState.setLogin(userLogin)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun getArguments(args: Bundle?) {
        userLogin = args?.getString("userLogin").toString()
    }
}