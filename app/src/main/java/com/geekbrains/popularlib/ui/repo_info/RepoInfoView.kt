package com.geekbrains.popularlib.ui.repo_info

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepoInfoView : MvpView {
    @AddToEndSingle
    fun setRepoName(repoName : String)

    @AddToEndSingle
    fun setRepoForks(repoForks : Int)
}