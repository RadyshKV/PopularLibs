package com.geekbrains.popularlib.model

import com.google.gson.annotations.Expose

data class GithubRepoModel(
    @Expose
    val name: String,

    @Expose
    val forksCount: Int,
)
