package com.geekbrains.popularlib.di.modules

import android.content.Context
import androidx.room.Room
import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.cache.IRepositoriesCache
import com.geekbrains.popularlib.db.cache.IUsersCache
import com.geekbrains.popularlib.db.cache.RoomGithubRepositoriesCache
import com.geekbrains.popularlib.db.cache.RoomGithubUsersCache
import com.geekbrains.popularlib.domain.GithubReposRepositoryImpl
import dagger.Module
import dagger.Provides

private const val DB_NAME = "database.db"

@Module
class CacheModule {

    @Provides
    fun db(context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java,
        DB_NAME
    )
        .build()

    @Provides
    fun usersCache(db: AppDatabase): IUsersCache{
        return RoomGithubUsersCache(db)
    }

    @Provides
    fun reposCache(db: AppDatabase): IRepositoriesCache {
        return RoomGithubRepositoriesCache(db)
    }
}