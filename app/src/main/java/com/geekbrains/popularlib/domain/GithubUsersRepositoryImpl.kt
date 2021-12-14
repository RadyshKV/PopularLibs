package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.model.RoomGithubUser
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.remote.RetrofitService
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single


class GithubUsersRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase,
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getUsers()
                .flatMap { users ->
                    Single.fromCallable {
                        val roomUsers = users.map { user ->
                            RoomGithubUser(user.id, user.login, user.avatarUrl, user.reposUrl)
                        }
                        db.userDao.insert(roomUsers)
                        users
                    }
                }
        } else {
            Single.fromCallable {
                db.userDao.getAll().map { roomModel ->
                    GithubUserModel(roomModel.id, roomModel.login, roomModel.avatarUrl, roomModel.reposUrl)
                }
            }
        }
    }
}