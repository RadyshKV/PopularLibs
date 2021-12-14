package com.geekbrains.popularlib.ui.repo_info


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepoInfoPresenter(
    private val repoName: String?,
    private val repoForks: Int,
    private val router: Router,
) : MvpPresenter<RepoInfoView>() {



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setRepoName()
        setRepoForks()
    }

    private fun setRepoName() {
        viewState.setRepoName(repoName)
    }

    private fun setRepoForks() {
        viewState.setRepoForks(repoForks)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}