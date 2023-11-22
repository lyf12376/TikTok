package com.Yi.videoplayer.Pages.login


import android.util.Log
import androidx.lifecycle.ViewModel
import com.Yi.videoplayer.bean.user.UserAccount
import com.Yi.videoplayer.network.UserService
import com.example.roomtest.room.savedUser.SavedUser
import com.example.roomtest.room.savedUser.SavedUserDao
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedUserDao: SavedUserDao,
    private val service: UserService
) : ViewModel() {

    val savedUserList: Flow<List<SavedUser>> = getSavedUser()

    fun isLogin(user:UserAccount):String
    {
        var token =""
        service.login(user).enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val body = response.body().toString()
                val jsonObject = JSONObject(body)
                if (jsonObject.has("code")){
                    val code = jsonObject.getInt("code")
                    //后端接口规定code=0为正常数据
                    if (code == 200){
                        token = jsonObject.getJSONObject("data").getString("token")
                    }
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d("HomeViewModel","error message=${t.message}")
            }
        })
        return token
    }

    fun saveUser(savedUser: SavedUser) {
        savedUserDao.saveUsers(savedUser)
    }

    private fun getSavedUser(): Flow<List<SavedUser>> {
        return savedUserDao.getSavedUsers()
    }

    fun deleteUser(account: String) {
        savedUserDao.unRemember(account)
    }

}
