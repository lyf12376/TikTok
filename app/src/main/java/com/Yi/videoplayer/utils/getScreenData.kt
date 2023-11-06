package com.Yi.videoplayer.utils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.Yi.videoplayer.Pages.ScreenData

@Composable
fun getScreenData()
{
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp
    ScreenData.screenWidthDp = screenWidthDp
    ScreenData.screenHeightDp = screenHeightDp
}