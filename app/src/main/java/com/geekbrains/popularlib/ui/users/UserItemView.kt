package com.geekbrains.popularlib.ui.users

import com.geekbrains.popularlib.ui.base.IItemView

interface UserItemView: IItemView {
    fun setLogin(login: String)
}