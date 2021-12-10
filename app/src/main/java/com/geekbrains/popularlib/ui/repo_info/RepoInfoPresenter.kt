package com.geekbrains.popularlib.ui.repo_info


import android.os.Bundle
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepoInfoPresenter(
    private val router: Router,
) : MvpPresenter<RepoInfoView>() {

    private var repoName: String = "Repo"
    private var repoForks: Int = 0

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

    fun getArguments(args: Bundle?) {
        repoName = args?.getString("repoName").toString()
        repoForks= args?.getInt("repoForks")!!
    }
}