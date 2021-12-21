package com.geekbrains.popularlib.di.modules

import android.content.Context
import androidx.room.Room
import com.geekbrains.popularlib.db.AppDatabase
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
}