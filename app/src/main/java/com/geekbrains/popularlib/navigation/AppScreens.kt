package com.geekbrains.popularlib.navigation

import androidx.core.os.bundleOf
import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.ui.repo_info.RepoInfoFragment
import com.geekbrains.popularlib.ui.repos.ReposFragment
import com.geekbrains.popularlib.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
interface AppScreens{
    fun usersScreen(): FragmentScreen

    fun reposScreen(userModel: GithubUserModel): FragmentScreen

    fun repoInfoScreen(repoModel: GithubRepoModel): FragmentScreen
}


class AppScreensImpl: AppScreens {
    override fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    override fun reposScreen(userModel: GithubUserModel) = FragmentScreen {
        ReposFragment.newInstance(userModel)
    }

    override fun repoInfoScreen(repoModel: GithubRepoModel) = FragmentScreen {
        RepoInfoFragment.newInstance(repoModel)
    }
}