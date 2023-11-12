package com.Yi.videoplayer.utils

import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

@Composable
fun ImageBitmapConverter(@DrawableRes id: Int): ImageBitmap {
    val vectorDrawable = AppCompatResources.getDrawable(LocalContext.current, id)
    val bitmap = Bitmap.createBitmap(
        vectorDrawable!!.intrinsicWidth,
        vectorDrawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )
    return bitmap.asImageBitmap()
}
