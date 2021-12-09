package com.geekbrains.popularlib.ui.user_info

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UserInfoView : MvpView {
    @AddToEndSingle
    fun setLogin(login : String)
}