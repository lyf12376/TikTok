package com.Yi.videoplayer.Pages.homePage.recommend

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
import com.Yi.videoplayer.CustomAnimation.LikeAnimation
import com.Yi.videoplayer.CustomAnimation.StorageAnimation
import com.Yi.videoplayer.CustomView.Video
import com.Yi.videoplayer.Pages.ScreenData
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.shortVideo.ShortVideo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendPage(recommendViewModel: RecommendViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val shortVideo =
        ShortVideo(Author("李仁🐎", "photo.url"), "这是一个测试", 10, 10, 0, 0, emptyList())

    val recommendVideoList = remember {
        mutableListOf<ShortVideo>()
    }
    recommendVideoList.add(shortVideo)

    VerticalPager(
        pageCount = recommendVideoList.size, state = pagerState, modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        RecommendVideo(recommendVideoList[it])
    }

}

@Composable
fun RecommendVideo(shortVideo: ShortVideo) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.CenterEnd
    ) {
        VideoPlayer(Modifier.align(Alignment.Center))
        RightItemColumn(userPhoto = R.drawable.add, shortVideo = shortVideo)
        content(video = shortVideo)
    }
}

@Composable
fun VideoPlayer(modifier: Modifier) {
    Video(modifier)
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
    viewModel: RecommendViewModel = hiltViewModel()
) {
    var likeScale = remember {
        Animatable(1f)
    }
    var storageScale = remember {
        Animatable(1f)
    }
    var liked by remember {
        mutableStateOf(false)
    }
    var storaged by remember {
        mutableStateOf(false)
    }
    var offset = remember {
        mutableStateOf(0.dp)
    }
    var alpha = remember {
        Animatable(1f)
    }

    LaunchedEffect(liked) {
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
        alpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 400,
                easing = FastOutSlowInEasing
            )
        )
    }

    LaunchedEffect(storaged) {
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

    val like by viewModel.like
    val likes by viewModel.likes
    val storage by viewModel.storage
    val storages by viewModel.storages

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
                widthDp = 40.dp, heightDp = 40.dp, modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )
            VideoItems(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                resId = R.drawable.comment,
                description = "评论",
                times = 0
            )
            StorageAnimation(
                widthDp = 40.dp, heightDp = 40.dp, modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )
            VideoItems(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                resId = R.drawable.share,
                description = "分享",
                times = 0
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
