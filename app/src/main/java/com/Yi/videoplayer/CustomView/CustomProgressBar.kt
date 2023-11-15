package com.Yi.videoplayer.CustomView

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomProgressBar (value:MutableState<Float>){

    var progress by value
    var isPlaying by remember {
        mutableStateOf(false)
    }
//    LaunchedEffect(isPlaying){
//        process.animateTo(
//            targetValue = 100f,
//            animationSpec = tween(
//                durationMillis = 30000
//            )
//        )
//    }
    LaunchedEffect(key1 = progress){
        Log.d("1234654", "CustomProgressBar: $progress")
    }
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 4.dp)
        .height(100.dp)
    ){
        val canvasWidth = size.width  // 画布的宽
        val canvasHeight = size.height  // 画布的高
        val strokeWidth = canvasHeight / 20
        val path = Path()
        path.lineTo(canvasWidth*(progress/1f), 0f)

        drawPath(
            path = path,
            style = Stroke(
                width = strokeWidth,
                cap = StrokeCap.Round
            ),
            color = Color.Red

        )


    }
}