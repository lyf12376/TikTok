package com.Yi.videoplayer.Pages.homePage.recommend

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.recommend.recommendVideo

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendPage(recommendViewModel: recommendViewModel = hiltViewModel())
{
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val recommendVideo = recommendVideo(Author("李仁🐎","photo.url"), 10, 10, 0, emptyList())

    VerticalPager(pageCount = 3) {
        when(it){
            1 -> {}
        }
    }

}

@Composable
fun RecommendVideo(){
    Box(modifier = Modifier.background(Color.LightGray)){

    }
}