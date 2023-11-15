package com.Yi.videoplayer.CustomView

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.Yi.videoplayer.R

@Composable
@Preview
fun Video() {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem =
        MediaItem.fromUri("https://v3-web.douyinvod.com/88190629246ba42dafa64f943f00af87/6554404b/video/tos/cn/tos-cn-ve-15c001-alinc2/oAleCnLG7B2Q4Ae9FAFIDITgESAqgBb53cjnD8/?a=6383&ch=26&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=1205&bt=1205&cs=0&ds=4&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiX3qfOFVJEUyy75vPD-I&mime_type=video_mp4&qs=0&rc=OmQ2NGZpNmlkZWU7aWk1M0BpM3VuajU6ZmhybzMzNGkzM0AvLTVfL14uNWAxYzE2Xl8uYSNjMmJlcjRvYjJgLS1kLS9zcw%3D%3D&btag=e00010000&dy_q=1700016683&feature_id=46a7bb47b4fd1280f3d3825bf2b29388&l=20231115105123E3C423A3957A2A635771")
    exoPlayer.setMediaItem(mediaItem)
    exoPlayer.prepare()
    exoPlayer.play()
    PlayerSurface(
        modifier = Modifier
            .wrapContentSize(),
        exoPlayer
    ) {
        it.player = exoPlayer
    }
}

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
                    onPress = { /* Called when the gesture starts */ },
                    onDoubleTap = { /* Called on Double Tap */ },
                    onLongPress = {
                                  exoPlayer.setPlaybackSpeed(2f)
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

