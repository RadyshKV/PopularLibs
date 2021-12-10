package com.geekbrains.popularlib.ui.users

import android.util.Log
import com.geekbrains.popularlib.domain.GithubUsersRepository
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.screens.AppScreens
import com.geekbrains.popularlib.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        usersListPresenter.itemClickListener = {
            router.navigateTo(
                AppScreens.reposScreen(
                    usersListPresenter.users.get(it.pos).reposUrl
                )
            )
        }
    }

    private fun loadData() {

        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                { users ->
                    usersListPresenter.users.addAll(users)
                    viewState.updateList()
                    viewState.hideLoading()
                }, { e ->
                    Log.e("Retrofit", "Ошибка при получении пользователей", e)
                    viewState.hideLoading()
                }
            )
    }

    class UsersListPresenter : IListPresenter<UserItemView> {
        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: ((UserItemView) -> Unit)? = {}

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
            view.loadImage(user.avatarUrl)
        }

        override fun getCount() = users.size
    }

    fun backPressed(): Boolean {
        //router.exit()
        return true
    }
}