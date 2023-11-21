package com.Yi.videoplayer.Pages.shortVideo.homePage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Yi.videoplayer.bean.login.Captcha
import com.Yi.videoplayer.bean.shortVideo.ShortVideoResponse
import com.Yi.videoplayer.bean.user.User
import com.Yi.videoplayer.bean.user.UserAccount
import com.Yi.videoplayer.network.UserService
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val service:UserService) : ViewModel() {

//    fun test(){
//        service.sendMail(Captcha("1357587070@qq.com","regist")).enqueue(object : Callback<JsonObject> {
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                val body = response.body().toString()
//                Log.d("-=-=-=-=-=-=-=-=-=-=", "onResponse: $body")
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                viewModelScope.launch {
//                    Log.d("-=-=-=-=-=-=-=-","error message=${t.message}")
//                }
//            }
//        })
//    }

}