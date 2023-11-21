package com.Yi.videoplayer.Room.User

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.Yi.videoplayer.Room.User.Users

@Dao
interface UsersDao {
    @Insert
    fun saveUser(users: Users):Long

    @Query("DELETE FROM Users")
    fun deleteAll()

    @Query("UPDATE Users SET password = :password, name = :name, photo = :photo, gender = :gender WHERE account = :account")
    fun updateUser(account: String, password: String, name:String, photo:String, gender:String)

    @Query("SELECT * FROM Users WHERE account = :account AND password = :password")
    fun findUser(account: String, password: String): Users?

    @Query("SELECT * FROM Users WHERE account = :account")
    fun findUserByAccount(account: String): Users?

    @Query("SELECT * FROM Users WHERE account = :account")
    fun isUserExist(account: String): Users?

}

