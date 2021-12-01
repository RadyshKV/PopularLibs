package com.geekbrains.popularlib.ui.users

import com.geekbrains.popularlib.domain.GithubUsersRepository
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.screens.AppScreens
import com.geekbrains.popularlib.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
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
            router.navigateTo(AppScreens.userInfoScreen(it.pos))
        }
    }

    private fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    class UsersListPresenter : IListPresenter<UserItemView> {
        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: ((UserItemView) -> Unit)? = {}

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}