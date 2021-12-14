package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.model.RoomGithubRepo
import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.model.GithubRepoOwner
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.remote.RetrofitService
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single


class GithubReposRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase,
) : GithubReposRepository {

    override fun getRepos(userModel: GithubUserModel): Single<List<GithubRepoModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getRepos(userModel.reposUrl)
                .flatMap { repos ->
                    Single.fromCallable {
                        val roomRepos = repos.map { repo ->
                            RoomGithubRepo(repo.id, repo.name, repo.owner.id, repo.forksCount)
                        }
                        db.repoDao.insert(roomRepos)
                        repos
                    }
                }
        } else {
            Single.fromCallable {
                db.repoDao.getByUserId(userModel.id).map { roomModel ->
                    GithubRepoModel(
                        roomModel.id, roomModel.name, GithubRepoOwner(roomModel.id), roomModel.forksCount
                    )
                }
            }
        }
    }
}