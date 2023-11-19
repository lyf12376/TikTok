package com.Yi.videoplayer.bean.user

import com.Yi.videoplayer.bean.shortVideo.ShortVideo

data class UserDocument(
    val name: String,
    val introduce: String,
    val avatar: Int,
    val video: List<ShortVideo>
)
