package com.Yi.videoplayer.Pages.login

import com.example.roomtest.room.savedUser.SavedUser
import com.example.roomtest.room.savedUser.SavedUserDao
import com.Yi.videoplayer.Room.User.UsersDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val savedUserDao: SavedUserDao,
    private val usersDao: UsersDao
) {

    fun saveUser(savedUser: SavedUser) {
        savedUserDao.saveUsers(savedUser)
    }

    fun getSavedUserList(): Flow<List<SavedUser>> {
        return savedUserDao.getSavedUsers()
    }

    fun deleteUser(account: String) {
        savedUserDao.unRemember(account)
    }

    fun isLogin(account: String, password: String): Boolean {
        return usersDao.findUser(account, password) != null
    }

}