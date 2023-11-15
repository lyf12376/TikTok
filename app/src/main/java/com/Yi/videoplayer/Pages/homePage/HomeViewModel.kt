package com.Yi.videoplayer.Pages.homePage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Yi.videoplayer.bean.user.User
import com.Yi.videoplayer.network.VideoService
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val retrofit: Retrofit) : ViewModel() {

//    fun test(){
//
//        val videoService = retrofit.create(VideoService::class.java)
//        videoService.test(User("py","1234")).enqueue(object :Callback<JsonObject>{
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