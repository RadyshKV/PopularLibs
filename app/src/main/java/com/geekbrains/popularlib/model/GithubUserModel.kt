package com.geekbrains.popularlib.model

import com.google.gson.annotations.Expose

data class GithubUserModel(
    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,

    @Expose
    val reposUrl: String,

)