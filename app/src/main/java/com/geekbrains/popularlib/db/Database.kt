package com.geekbrains.popularlib.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.db.dao.RepoDao
import com.geekbrains.popularlib.db.dao.UserDao
import com.geekbrains.popularlib.db.model.RoomGithubRepo
import com.geekbrains.popularlib.db.model.RoomGithubUser

@Database(
    entities = [
        RoomGithubUser::class,
        RoomGithubRepo::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repoDao: RepoDao

    companion object{
        private const val DB_NAME = "database.db"
        val instance by lazy {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }
}