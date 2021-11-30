package com.geekbrains.popularlib.screens

import com.geekbrains.popularlib.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {
    fun usersScreen() = FragmentScreen{
        UsersFragment()
    }
}