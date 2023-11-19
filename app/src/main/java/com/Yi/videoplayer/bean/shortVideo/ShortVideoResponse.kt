package com.Yi.videoplayer.bean.shortVideo

data class ShortVideoResponse(
    val code: Int,
    val message: String,
    val video: ShortVideo,
    val isLike: Int
)

