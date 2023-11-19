package com.Yi.videoplayer.bean.user

data class User(
    val nickName: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val code: String //验证码
)