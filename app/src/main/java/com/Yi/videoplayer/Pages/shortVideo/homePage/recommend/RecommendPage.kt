package com.Yi.videoplayer.Pages.shortVideo.homePage.recommend

import android.util.Log
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.Yi.videoplayer.Pages.shortVideo.ShortVideoViewModel
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.shortVideo.ShortVideo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendPage(recommendViewModel: RecommendViewModel= hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()


    val recommendVideoList by recommendViewModel.shortVideoList.collectAsState()
    Log.d("length", "RecommendPage: ${recommendVideoList.size}")



    VerticalPager(
        pageCount = recommendVideoList.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
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
        RightItemColumn(userAvatar = R.drawable.add, pagerState,shortVideo)
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RightItemColumn(
    userAvatar: Int,
    pagerState: PagerState,
    shortVideo: ShortVideo,
    viewModel: RecommendViewModel = hiltViewModel()
) {
    val recommendVideoList by viewModel.shortVideoList.collectAsState()
    Box(
        modifier = Modifier
            .padding(top = ScreenData.screenHeightDp / 2.5f)
    ) {
        Column {
            Icon(
                painterResource(id = userAvatar),
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
                index = shortVideo.id,
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
                index = shortVideo.id,
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
