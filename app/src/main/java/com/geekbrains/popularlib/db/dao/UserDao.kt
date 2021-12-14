package com.geekbrains.popularlib.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geekbrains.popularlib.db.model.RoomGithubUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGithubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubUser>)

    @Query( "SELECT * FROM RoomGithubUser" )
    fun getAll(): List<RoomGithubUser>

    @Query( "SELECT * FROM RoomGithubUser WHERE login = :login LIMIT 1" )
    fun getByLogin(login: String): RoomGithubUser?
}