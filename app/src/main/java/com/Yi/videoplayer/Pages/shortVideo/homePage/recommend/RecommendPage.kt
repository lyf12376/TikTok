package com.Yi.videoplayer.Pages.shortVideo.homePage.recommend

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.exoplayer.ExoPlayer
import com.Yi.videoplayer.CustomAnimation.LikeAnimation
import com.Yi.videoplayer.CustomAnimation.StorageAnimation
import com.Yi.videoplayer.CustomView.Video
import com.Yi.videoplayer.Pages.ScreenData
import com.Yi.videoplayer.Pages.shortVideo.ShortVideoViewModel
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.shortVideo.ShortVideo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendPage(shortVideoViewModel: ShortVideoViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val shortVideo1 =
        ShortVideo(
            "https://v3-web.douyinvod.com/1624b96814a2c170781063b8150bd9ff/65586bf1/video/tos/cn/tos-cn-ve-15c001-alinc2/ownPHDEjSI5Hae6AgNdbQZiy0XvWB9gcelQuAA/?a=6383&ch=5&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=2034&bt=2034&cs=0&ds=3&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiXE5h1FVJEYLy75vPD-I&mime_type=video_mp4&qs=0&rc=NjRmZjtnaTpnaTRoOTlkOUBpampsNDU6ZjlobjMzNGkzM0AyMjUtMGMwNTAxXzE1Xi4vYSMya3E0cjRnNmNgLS1kLWFzcw%3D%3D&btag=e00030000&dy_q=1700289536&feature_id=f0150a16a324336cda5d6dd0b69ed299&l=202311181438558DDA17F69E858D626F6A",
            Author("傻逼", "photo.url"),
            "这是一个测试",
            10,
            false,
            10,
            0,
            false,
            0,
            emptyList()
        )

    val shortVideo2 =
        ShortVideo(
            "https://v3-web.douyinvod.com/f79d5349c4f83204115f226053224215/65586a1d/video/tos/cn/tos-cn-ve-15c001-alinc2/oYIEOyBAhBwCvgetGFEA9fhAsFzP5pQBXNZYyD/?a=6383&ch=5&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=1283&bt=1283&cs=0&ds=3&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiXE5h1FVJEYLy75vPD-I&mime_type=video_mp4&qs=1&rc=ODU3NGc6NDM1ZTY1PDY6NEBpanNudTk6ZmY0bzMzNGkzM0A2MGBfLTU0Xi4xMTBfXy8uYSNgMDVfcjQwYDRgLS1kLTBzcw%3D%3D&btag=e00008000&dy_q=1700289536&feature_id=46a7bb47b4fd1280f3d3825bf2b29388&l=202311181438558DDA17F69E858D626F6A",
            Author("傻逼", "photo.url"),
            "这是一个测试",
            5,
            true,
            11,
            0,
            false,
            0,
            emptyList()
        )

    val shortVideo3 =
        ShortVideo(
            "https://v26-web.douyinvod.com/56a624f8c3a6ee6943e804fd61664aaf/655878c7/video/tos/cn/tos-cn-ve-15c001-alinc2/oEasOffbgwADRAIN4JcQZDHeEeBqYseNpC7BA2/?a=6383&ch=26&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=1711&bt=1711&cs=0&ds=6&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiX~7g1FVJEYLy75vPD-I&mime_type=video_mp4&qs=12&rc=OTdnaGlmNDlnNWlpNDQzZUBpM2d4bjY6Zjk7bjMzNGkzM0AvNjZjX2ItXjUxNjQwL18vYSNrai9tcjRvMWdgLS1kLS9zcw%3D%3D&btag=e00038000&dy_q=1700292541&feature_id=46a7bb47b4fd1280f3d3825bf2b29388&l=2023111815290136AAC805344E288B8999",
            Author("傻逼", "photo.url"),
            "这是一个测试",
            5,
            true,
            11,
            0,
            false,
            0,
            emptyList()
        )

    val shortVideo4 =
        ShortVideo(
            "https://v3-web.douyinvod.com/35300bb33c5d558b0cf1826d18726c79/65587b23/video/tos/cn/tos-cn-ve-15c001-alinc2/oEteIA1oSOxxTR5qRRBoE7xdgSfSAyANdVzDth/?a=6383&ch=224&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=906&bt=906&cs=0&ds=4&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiXccg1FVJEYLy75vPD-I&mime_type=video_mp4&qs=0&rc=MzQ6NjQ4M2dkOTk0OTs6OEBpM2s4aGg6ZnJ1bTMzNGkzM0AtYi41L18vNl4xLzZhXzRjYSM2XmJocjRvaWhgLS1kLTBzcw%3D%3D&btag=e00038000&dy_q=1700292590&feature_id=f0150a16a324336cda5d6dd0b69ed299&l=2023111815294958CCEF54F7129C72C76B",
            Author("傻逼", "photo.url"),
            "这是一个测试",
            5,
            true,
            11,
            0,
            false,
            0,
            emptyList()
        )

    val recommendVideoList = remember {
        mutableListOf<ShortVideo>()
    }
    recommendVideoList.add(shortVideo1)
    recommendVideoList.add(shortVideo2)
    recommendVideoList.add(shortVideo3)
    recommendVideoList.add(shortVideo4)



    VerticalPager(
        pageCount = recommendVideoList.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        key = {recommendVideoList[it].address}
    ) {
        RecommendVideo(shortVideo = recommendVideoList[it], pagerState = pagerState, pageIndex = it)
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendVideo(shortVideo: ShortVideo, pagerState: PagerState, pageIndex: Int) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Video(Modifier.align(Alignment.Center), shortVideo.address, pagerState = pagerState, pageIndex = pageIndex)
        RightItemColumn(userPhoto = R.drawable.add, shortVideo = shortVideo)
        content(video = shortVideo)
    }
}

@Composable
fun content(video: ShortVideo) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), contentAlignment = Alignment.BottomStart
    ) {
        Column {
            Text(
                text = "@${video.author.name}",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(
                text = video.introduction,
                modifier = Modifier
                    .padding(12.dp),
                color = Color.White,
                fontSize = 24.sp
            )
        }

    }

}

@Composable
fun RightItemColumn(
    userPhoto: Int,
    shortVideo: ShortVideo,
    viewModel: ShortVideoViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .padding(top = ScreenData.screenHeightDp / 2.5f)
    ) {
        Column {
            Icon(
                painterResource(id = userPhoto),
                modifier = Modifier
                    .padding(8.dp)
                    .size(50.dp)
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                contentDescription = "头像",
                tint = Color.Unspecified
            )
            LikeAnimation(
                widthDp = 40.dp,
                heightDp = 40.dp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                shortVideo = shortVideo
            )
            VideoItems(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                resId = R.drawable.comment,
                description = "评论",
                times = shortVideo.totalComments
            )
            StorageAnimation(
                widthDp = 40.dp,
                heightDp = 40.dp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                shortVideo = shortVideo
            )
            VideoItems(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                resId = R.drawable.share,
                description = "分享",
                times = shortVideo.shares
            )

        }
    }

}

@Composable
fun VideoItems(
    modifier: Modifier,
    resId: Int,
    description: String,
    times: Int,
    click: Modifier = Modifier
) {
    Column(modifier) {

        Box {
            Icon(
                painterResource(id = resId), modifier = click
                    .align(Alignment.Center)
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
                    .size(40.dp),
                contentDescription = description,
                tint = Color.Unspecified
            )
        }

        Text(
            text = "$times",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp), fontSize = 24.sp,
            color = Color.White
        )
    }
}
