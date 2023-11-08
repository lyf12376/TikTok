package com.Yi.videoplayer.Pages.homePage.recommend

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.recommend.recommendVideo

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendPage(recommendViewModel: recommendViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val recommendVideo = recommendVideo(Author("李仁🐎", "photo.url"), 10, 10, 0, 0, emptyList())

    VerticalPager(pageCount = 3) {
        when (it) {
            1 -> {}
        }
    }

}

@Preview
@Composable
fun RecommendVideo() {
    val recommendVideo = recommendVideo(Author("李仁🐎", "photo.url"), 10, 10, 0, 0, emptyList())
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
    ) {
        RightItemColumn(userPhoto = R.drawable.add, recommendVideo = recommendVideo)
    }
}

@Composable
fun RightItemColumn(
    userPhoto: Int,
    recommendVideo: recommendVideo,
    recommendViewModel: recommendViewModel = hiltViewModel()
) {
    val like by recommendViewModel.like
    Column {
        Icon(
            painterResource(id = userPhoto),
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp),
            contentDescription = "头像"
        )
        Icon(
            painterResource(id = if (like) R.drawable.like_selected else R.drawable.like_unselected),
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
                .clickable { recommendViewModel.like.value = !recommendViewModel.like.value },
            contentDescription = "喜欢",
            tint = Color.Unspecified
        )
    }

}