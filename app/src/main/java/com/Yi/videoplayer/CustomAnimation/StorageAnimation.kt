package com.Yi.videoplayer.CustomAnimation

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.Yi.videoplayer.Pages.shortVideo.ShortVideoViewModel
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.shortVideo.ShortVideo
import com.Yi.videoplayer.utils.DpToPx
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun StorageAnimation(
    widthDp: Dp,
    heightDp: Dp,
    modifier: Modifier,
    shortVideo: ShortVideo,
    viewModel: ShortVideoViewModel = hiltViewModel()
) {
    var start by remember {
        mutableStateOf(false)
    }
    var storageScale = remember {
        Animatable(1f)
    }
    var storaged by remember {
        mutableStateOf(shortVideo.isStorage)
    }
    var storages by remember {
        mutableStateOf(shortVideo.storage)
    }
    var enabled by remember {
        mutableStateOf(true)
    }
    val offsetX = DpToPx(dp = 50.dp)
    val animScale = remember {
        Animatable(1f)
    }
    var isClicked by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(storaged) {
        if (storaged) {
            storageScale.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 0
                )
            )
            storageScale.animateTo(
                targetValue = 1.2f,
                animationSpec = tween(
                    durationMillis = 400,
                    easing = FastOutSlowInEasing
                )
            )
            storageScale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }
    }
    LaunchedEffect(isClicked) {
        if (isClicked) {
            animScale.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 0
                )
            )
            animScale.animateTo(
                targetValue = 1.5f,
                animationSpec = tween(
                    durationMillis = 600,
                    easing = FastOutSlowInEasing
                )
            )
            delay(100)
            animScale.animateTo(
                targetValue = 0.95f,
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )
            animScale.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 10,
                    easing = FastOutSlowInEasing
                )
            )
            enabled = true
        }
    }
    val width = DpToPx(dp = widthDp)
    val height = DpToPx(dp = heightDp)

    val starPath = Path()
    val widthRect = width * 0.96f
    val heightRect = height * 0.96f
    val centerX = width / 2
    val centerY = height / 2
    val radius = width / 2
    val value = 0.8

    val anglePerPoint = Math.toRadians(36.0)
    var currentAngle = Math.toRadians(-90.0) // 从顶点开始绘制

    for (i in 0 until 10) {
        val pointRadius = if (i % 2 == 0) radius else radius * 0.5f
        val x = centerX + pointRadius * cos(currentAngle)
        val y = centerY + pointRadius * sin(currentAngle)
        //Log.d("TAG", "StorageAnimation: x $x, y $y")
        if (i == 0) {
            starPath.moveTo(x.toFloat(), y.toFloat())
        } else {
            starPath.lineTo(x.toFloat(), y.toFloat())
        }

        currentAngle += anglePerPoint
    }

    starPath.close()

    val pathMeasure = PathMeasure()
    pathMeasure.setPath(starPath, true) // 设置要测量的路径，并指定路径为封闭的

    val distanceInterval = 10f // 距离间隔，用于控制采样的密度
    val totalLength = pathMeasure.length // 获取路径的总长度

    val points = mutableListOf<Offset>() // 创建一个空的Offset集合，用于存储点的坐标

    var distance = 0f // 距离起点的距离
    while (distance <= totalLength) {
        val point = pathMeasure.getPosition(distance) // 获取路径上指定距离处的点的坐标
        //Log.d("TAG", "StorageAnimation: ${pathMeasure.getPosition(0f)}")
        points.add(point) // 将点的坐标添加到集合中

        distance += distanceInterval // 增加距离，以便获取下一个点的坐标
    }

    for (point in points) {
        // 处理每个点的坐标
        //Log.d("TAG", "LikeAnimation: $point")
    }


    Box(
        modifier = modifier
    ) {
        Column {
            Box(
                Modifier
                    .height(40.dp)
                    .width(40.dp)
            ) {
                Image(
                    painterResource(id = if (storaged) R.drawable.storage_selected else R.drawable.storage_unselected),
                    contentDescription = "收藏",
                    modifier = Modifier
                        .align(
                            Alignment.Center
                        )
                        .size(40.dp)
                        .scale(storageScale.value)
                        .clickable(enabled = enabled) {
                            start = true
                            if (storaged) {
                                storaged = !storaged
                                storages--
                                isClicked = !isClicked
                            } else {
                                enabled = false
                                storaged = !storaged
                                storages++
                                isClicked = !isClicked
                            }
                        }
                )
                Canvas(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .height(40.dp)
                        .width(40.dp)
                ) {
//                    drawCircle(color = Color.Red, radius = heightRect/2, center = Offset(width/2,height/2))
                    scale(animScale.value) {
                        if (start) {
                            drawPoints(
                                points.toList(),
                                pointMode = PointMode.Points,
                                Color.Yellow,
                                strokeWidth = 2.5f
                            )
                        }
                    }

                }
            }

            Text(
                text = "$storages",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 24.sp,
                color = Color.White
            )

        }

    }
}

//@Composable
//@Preview
//fun starPrev(){
//    StorageAnimation(widthDp = 40.dp, heightDp = 40.dp, modifier = Modifier)
//
//}