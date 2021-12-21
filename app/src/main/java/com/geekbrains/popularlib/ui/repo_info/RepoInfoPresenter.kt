package com.geekbrains.popularlib.ui.repo_info

import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class RepoInfoPresenter @AssistedInject constructor(
    @Assisted private val repoName: String?,
    @Assisted private val repoForks: Int,
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

@AssistedFactory
interface RepoInfoPresenterFactory{
    fun presenter(repoName: String?, repoForks: Int): RepoInfoPresenter
}