package com.geekbrains.popularlib

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainView : MvpView {
    @AddToEndSingle
    fun setButtonText1(text: String)

    @AddToEndSingle
    fun setButtonText2(text: String)

    @AddToEndSingle
    fun setButtonText3(text: String)
}