package com.geekbrains.popularlib.screens

import androidx.core.os.bundleOf
import com.geekbrains.popularlib.ui.user_info.UserInfoFragment
import com.geekbrains.popularlib.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {
    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userInfoScreen(userLogin: String) = FragmentScreen {
        UserInfoFragment().apply {
            arguments = bundleOf("userLogin" to userLogin)
        }
    }
}