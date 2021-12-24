package com.geekbrains.popularlib.ui.repo_info

import com.geekbrains.popularlib.di.scope.containers.RepoInfoScopeContainer
import com.geekbrains.popularlib.model.GithubRepoModel
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class RepoInfoPresenter @AssistedInject constructor(
    @Assisted private val repoModel: GithubRepoModel,
    private val repoInfoScopeContainer: RepoInfoScopeContainer,
    private val router: Router,
) : MvpPresenter<RepoInfoView>() {

    override fun onDestroy() {
        repoInfoScopeContainer.destroyRepoInfoSubcomponent()
        super.onDestroy()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setRepoName()
        setRepoForks()
    }

    private fun setRepoName() {
        viewState.setRepoName(repoModel.name)
    }

    private fun setRepoForks() {
        viewState.setRepoForks(repoModel.forksCount)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

@AssistedFactory
interface RepoInfoPresenterFactory{
    fun presenter(repoModel: GithubRepoModel): RepoInfoPresenter
}