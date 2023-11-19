package com.Yi.videoplayer.CustomView

import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.Player.REPEAT_MODE_ONE
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.Yi.videoplayer.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
fun Video(modifier: Modifier, uri: String, pagerState: PagerState, pageIndex: Int) {
    val context = LocalContext.current
    var isFirstFrameLoad = remember { false }
//    val exoPlayer = ExoPlayer.Builder(context).build()
//    val mediaItem = MediaItem.fromUri(uri)
//    //Log.d("TAG", "Video: ===---$uri---===")
//    exoPlayer.setMediaItem(mediaItem)
//    exoPlayer.prepare()
//    exoPlayer.play()
//    exoPlayer.repeatMode = REPEAT_MODE_ONE
//    PlayerSurface(
//        modifier = modifier.fillMaxWidth(),
//        exoPlayer,
//    ) {
//        it.player = exoPlayer
//    }
        if (pagerState.settledPage == pageIndex) {
        val exoPlayer = remember(context) {
            ExoPlayer.Builder(context).build().apply {
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
                repeatMode = REPEAT_MODE_ONE
                setMediaItem(MediaItem.fromUri(uri))
                playWhenReady = true
                prepare()
                addListener(object : Player.Listener {
                    override fun onRenderedFirstFrame() {
                        super.onRenderedFirstFrame()
                        isFirstFrameLoad = true
                        //thumbnail = thumbnail.copy(second = false)
                    }
                })
            }
        }

        val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
        DisposableEffect(key1 = lifecycleOwner) {
            val lifeCycleObserver = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_STOP -> {
                        exoPlayer.pause()
                    }
                    Lifecycle.Event.ON_START -> exoPlayer.play()
                    else -> {}
                }
            }
            lifecycleOwner.lifecycle.addObserver(lifeCycleObserver)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(lifeCycleObserver)
            }
        }

        val playerView = remember {
            PlayerView(context).apply {
                player = exoPlayer
                useController = false
//                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
//                layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
//                )
            }
        }

        DisposableEffect(key1 = AndroidView(factory = {
            playerView
        }, modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                //onSingleTap(exoPlayer)
            }, onDoubleTap = { offset ->
                //onDoubleTap(exoPlayer, offset)
            })
        }), effect = {
            onDispose {
                //thumbnail = thumbnail.copy(second = true)
                exoPlayer.release()
                //onVideoDispose()
            }
        })
            PlayerSurface(modifier = modifier, exoPlayer = exoPlayer){
                it.player = exoPlayer
            }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayerSurface(
    modifier: Modifier,
    exoPlayer: ExoPlayer,
    onPlayerViewAvailable: (PlayerView) -> Unit
) {
    var isPlaying by remember {
        mutableStateOf(true)
    }
    Box(modifier) {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    useController = false
                    onPlayerViewAvailable(this)
                }
            },
            modifier = modifier.pointerInput(Unit) {
                detectTapGestures(
                    onPress = {  },
                    onDoubleTap = {

                    },
                    onTap = {
                        isPlaying = if (exoPlayer.isPlaying) {
                            exoPlayer.pause()
                            !isPlaying
                        } else {
                            exoPlayer.play()
                            !isPlaying
                        }
                    }
                )

            }
        )
        Image(
            painterResource(id = R.drawable.play),
            contentDescription = "播放",
            modifier = if (isPlaying) Modifier
                .alpha(0f)
                .size(40.dp)
                .align(
                    Alignment.Center
                ) else Modifier
                .alpha(1f)
                .size(40.dp)
                .align(Alignment.Center)
        )
    }

}

//@Composable
//fun CustomPlayerControls(exoPlayer: ExoPlayer) {
//    var isPlaying by remember {
//        mutableStateOf(true)
//    }
//
//    // 创建自定义的播放控制层
//    Box(
//        modifier = Modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.Center
//    ) {
//        // 播放/暂停按钮
////        IconButton(onClick = {
////            if (exoPlayer.isPlaying) {
////                exoPlayer.pause()
////                isPlaying = !isPlaying
////                Log.d("TAG", "onPlaybackStateChanged: ${exoPlayer.isPlaying}")
////            } else {
////                exoPlayer.play()
////                isPlaying = !isPlaying
////                Log.d("TAG", "onPlaybackStateChanged: ${exoPlayer.isPlaying}")
////            }
////        }) {
////            Icon(
////                if (isPlaying) Icons.Outlined.Settings else Icons.Filled.PlayArrow,
////                contentDescription = null
////            )
////        }
//
//        // 进度条
//        val progress = remember { mutableStateOf(0f) }
//
//        LaunchedEffect(exoPlayer) {
//            while (true) {
//                progress.value = exoPlayer.currentPosition.toFloat() / exoPlayer.duration.toFloat()
//                delay(1000) // 每秒更新一次
//                Log.d("-=-=-=-=-=-=-=", "CustomPlayerControls: ${(progress.value)}")
//            }
//        }
//        CustomProgressBar(progress)
//    }
//}

