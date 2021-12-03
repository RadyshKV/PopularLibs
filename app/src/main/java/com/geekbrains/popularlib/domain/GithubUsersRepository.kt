package com.geekbrains.popularlib.domain

import com.geekbrains.popularlib.model.GithubUserModel
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class GithubUsersRepository {

    private val users = listOf(
        GithubUserModel("user1"),
        GithubUserModel("user2"),
        GithubUserModel("user3"),
        GithubUserModel("user4"),
        GithubUserModel("user5")
    )
    fun getUsersObserver(): @NonNull Observable<GithubUserModel> {
        return Observable.fromIterable(users)
    }

    fun interval(): @NonNull Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS)
    }

    fun getUsersZip(): @NonNull Observable<GithubUserModel> {
        return Observable.zip(getUsersObserver(), interval(), { o1, o2 -> o1 })
    }
}