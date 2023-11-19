package com.Yi.videoplayer.network

import com.Yi.videoplayer.bean.shortVideo.ShortVideoResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface VideoService {
    @GET
    fun getVideo(): ShortVideoResponse
}