package com.geekbrains.popularlib.db.cache

import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.model.RoomGithubRepo
import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubRepoOwner
import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class RoomGithubRepositoriesCache(
    private val db: AppDatabase
) : IRepositoriesCache {

    override fun setRepos(repos: List<GithubRepoModel>): Single<List<GithubRepoModel>> {
        return Single.fromCallable {
            val roomRepos = repos.map { repo ->
                RoomGithubRepo(repo.id, repo.name, repo.owner.id, repo.forksCount)
            }
            db.repoDao.insert(roomRepos)
            repos
        }
    }

    override fun getRepos(userModel: GithubUserModel): Single<List<GithubRepoModel>> {
        return Single.fromCallable {
            db.repoDao.getByUserId(userModel.id).map { roomModel ->
                GithubRepoModel(
                    roomModel.id, roomModel.name, GithubRepoOwner(roomModel.id), roomModel.forksCount
                )
            }
        }
    }
}