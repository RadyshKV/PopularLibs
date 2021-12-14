package com.geekbrains.popularlib.navigation

import androidx.core.os.bundleOf
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.ui.repo_info.RepoInfoFragment
import com.geekbrains.popularlib.ui.repos.ReposFragment
import com.geekbrains.popularlib.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {
    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun reposScreen(userModel: GithubUserModel) = FragmentScreen {
        ReposFragment.newInstance(userModel)
    }

    fun repoInfoScreen(repoName: String, repoForks: Int) = FragmentScreen {
        RepoInfoFragment.newInstance(repoName, repoForks)
    }
}