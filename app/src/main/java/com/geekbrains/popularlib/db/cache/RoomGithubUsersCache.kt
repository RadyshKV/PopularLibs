package com.geekbrains.popularlib.db.cache

import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.model.RoomGithubUser
import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomGithubUsersCache @Inject constructor(
    private val db: AppDatabase
): IUsersCache {

    override fun setUsers(users: List<GithubUserModel>): Single<List<GithubUserModel>> {
        return Single.fromCallable {
            val roomUsers = users.map { user ->
                RoomGithubUser(user.id, user.login, user.avatarUrl, user.reposUrl)
            }
            db.userDao.insert(roomUsers)
            users
        }
    }

    override fun getUsers(): Single<List<GithubUserModel>> {
        return Single.fromCallable {
            db.userDao.getAll().map { roomModel ->
                GithubUserModel(roomModel.id, roomModel.login, roomModel.avatarUrl, roomModel.reposUrl)
            }
        }
    }

}