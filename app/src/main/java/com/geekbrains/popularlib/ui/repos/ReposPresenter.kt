package com.geekbrains.popularlib.ui.repos

import android.util.Log
import com.geekbrains.popularlib.domain.GithubReposRepository
import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.navigation.AppScreens
import com.geekbrains.popularlib.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class ReposPresenter @AssistedInject constructor(
    private val router: Router,
    private val reposRepository: GithubReposRepository,
    private val appScreens: AppScreens,
    @Assisted private val userModel: GithubUserModel
) : MvpPresenter<ReposView>() {

    val reposListPresenter = ReposListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        reposListPresenter.itemClickListener = {
            router.navigateTo(
                appScreens.repoInfoScreen(
                    reposListPresenter.repos.get(it.pos)
                )
            )
        }
    }

    private fun loadData() {

        reposRepository.getRepos(userModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                { repos ->
                    reposListPresenter.repos.addAll(repos)
                    viewState.updateList()
                    viewState.hideLoading()
                }, { e ->
                    Log.e("Retrofit", "Ошибка при получении репозиториев", e)
                    viewState.hideLoading()
                }
            )
    }

    class ReposListPresenter : IListPresenter<RepoItemView> {
        val repos = mutableListOf<GithubRepoModel>()

        override var itemClickListener: ((RepoItemView) -> Unit)? = {}

        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            view.setName(repo.name)
        }

        override fun getCount() = repos.size
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

@AssistedFactory
interface ReposPresenterFactory{
    fun presenter(userModel: GithubUserModel): ReposPresenter
}
