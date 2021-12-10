package com.geekbrains.popularlib.screens

import androidx.core.os.bundleOf
import com.geekbrains.popularlib.ui.repo_info.RepoInfoFragment
import com.geekbrains.popularlib.ui.repos.ReposFragment
import com.geekbrains.popularlib.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {
    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun reposScreen(reposUrl: String) = FragmentScreen {
        ReposFragment().apply {
            arguments = bundleOf("reposUrl" to reposUrl)
        }
    }

    fun repoInfoScreen(repoName: String, repoForks: Int) = FragmentScreen {
        RepoInfoFragment().apply {
            arguments = bundleOf("repoName" to repoName, "repoForks" to repoForks)

        }
    }
}