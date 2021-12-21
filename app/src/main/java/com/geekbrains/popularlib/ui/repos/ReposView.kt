package com.geekbrains.popularlib.ui.repos

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ReposView : MvpView {
    @AddToEndSingle
    fun updateList()

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()

}