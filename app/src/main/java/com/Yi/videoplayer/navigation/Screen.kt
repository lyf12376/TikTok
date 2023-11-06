package com.Yi.videoplayer.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class Screen(val route: String, val description:String) {
    object LoginPage : Screen("LoginPage", "登录")

    object HomePage : Screen("HomePage", "首页")

    object FriendsPage : Screen("FriendsPage", "朋友")

    object MessagePage : Screen("MessagePage", "消息")

    object MinePage : Screen("MinePage","我的")

}
