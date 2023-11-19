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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.Yi.videoplayer.Pages.shortVideo.ShortVideoViewModel
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.shortVideo.ShortVideo
import com.Yi.videoplayer.utils.DpToPx
import kotlinx.coroutines.delay

@Composable
fun LikeAnimation(
    widthDp: Dp,
    heightDp: Dp,
    modifier: Modifier,
    shortVideo: ShortVideo,
    viewModel: ShortVideoViewModel = hiltViewModel()
) {
    var start by remember {
        mutableStateOf(false)
    }
    var likeScale = remember {
        Animatable(1f)
    }
    var liked by remember {
        mutableStateOf(shortVideo.isLike)
    }
    var likes by remember {
        mutableStateOf(shortVideo.like)
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
    LaunchedEffect(liked) {
        if (liked) {
            likeScale.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 0
                )
            )
            likeScale.animateTo(
                targetValue = 1.2f,
                animationSpec = tween(
                    durationMillis = 400,
                    easing = FastOutSlowInEasing
                )
            )
            likeScale.animateTo(
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
    val path = Path()
    val width = DpToPx(dp = widthDp)
    val height = DpToPx(dp = heightDp)
    path.moveTo(width / 2, height / 5);

    // Upper left path
    path.cubicTo(
        5 * width / 14, 0f,
        0f, height / 15,
        width / 28, 2 * height / 5
    )

    // Lower left path
    path.cubicTo(
        width / 14, 2 * height / 3,
        3 * width / 7, 5 * height / 6,
        width / 2, height
    )

    // Lower right path
    path.cubicTo(
        4 * width / 7, 5 * height / 6,
        13 * width / 14, 2 * height / 3,
        27 * width / 28, 2 * height / 5
    )

    // Upper right path
    path.cubicTo(
        width, height / 15,
        9 * width / 14, 0f,
        width / 2, height / 5
    )

    val pathMeasure = PathMeasure()
    pathMeasure.setPath(path, true) // 设置要测量的路径，并指定路径为封闭的

    val distanceInterval = 10f
    val totalLength = pathMeasure.length // 获取路径的总长度

    val points = mutableListOf<Offset>() // 创建一个空的Offset集合，用于存储点的坐标

    var distance = 0f // 距离起点的距离
    while (distance <= totalLength) {
        val point = pathMeasure.getPosition(distance) // 获取路径上指定距离处的点的坐标
        points.add(point)

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
                    painterResource(id = if (liked) R.drawable.like_selected else R.drawable.like_unselected),
                    contentDescription = "喜欢",
                    modifier = Modifier
                        .align(
                            Alignment.Center
                        )
                        .size(40.dp)
                        .scale(likeScale.value)
                        .clickable(enabled = enabled) {
                            start = true
                            if (liked) {
                                Log.d("TAG", "LikeAnimation: $liked")
                                liked = !liked
                                likes--
                                isClicked = !isClicked
                            } else {
                                enabled = false
                                liked = !liked
                                likes++
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
                    scale(animScale.value) {
                        if (start) {
                            drawPoints(
                                points.toList(),
                                pointMode = PointMode.Points,
                                Color.Red,
                                strokeWidth = 2.5f
                            )
                        }
                    }
                }
            }

            Text(
                text = "$likes",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 24.sp,
                color = Color.White
            )

        }

    }
}



