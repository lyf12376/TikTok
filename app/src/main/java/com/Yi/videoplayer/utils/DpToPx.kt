package com.Yi.videoplayer.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun DpToPx(dp: Dp): Float {
    return with(LocalDensity.current) {
        dp.toPx()
    }
}