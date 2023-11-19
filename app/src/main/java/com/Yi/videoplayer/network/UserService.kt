package com.Yi.videoplayer.network

import com.Yi.videoplayer.bean.login.Captcha
import com.Yi.videoplayer.bean.user.User
import com.Yi.videoplayer.bean.user.UserAccount
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("userAccount/login")
    fun login(@Body userAccount: UserAccount): Call<JsonObject>

    @POST("userAccount/register")
    fun register(@Body userAccount: User): Call<JsonObject>

    @POST("user/SendMail")
    fun sendMail(@Body captcha: Captcha): Call<JsonObject>
}