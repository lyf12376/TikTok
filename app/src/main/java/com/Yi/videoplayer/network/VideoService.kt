package com.Yi.videoplayer.network

import com.Yi.videoplayer.bean.user.User
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface VideoService {

    @POST("user/login")
    fun test(@Body user: User): Call<JsonObject>
}