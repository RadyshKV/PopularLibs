package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubUserModel

class GithubUsersRepository {

    private val users = listOf(
        GithubUserModel("user1"),
        GithubUserModel("user2"),
        GithubUserModel("user3"),
        GithubUserModel("user4"),
        GithubUserModel("user5")
    )
    fun getUsers(): List<GithubUserModel>{
        return users
    }
}