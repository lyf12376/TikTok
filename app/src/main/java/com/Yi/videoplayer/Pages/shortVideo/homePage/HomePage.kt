package com.Yi.videoplayer.Pages.shortVideo.homePage

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.Yi.videoplayer.Pages.longVideo.LongVideo
import com.Yi.videoplayer.Pages.shortVideo.homePage.recommend.RecommendPage
import com.Yi.videoplayer.bean.TabItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(paddingValues: PaddingValues, homeViewModel: HomeViewModel = hiltViewModel())
{
    val tabItems = listOf(
        TabItem(title = "推荐"),
        TabItem(title = "长视频"),

    )
    homeViewModel.test()


    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val systemUiController = rememberSystemUiController()
    val darkIconsState = remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background( when(pagerState.currentPage){
            0->Color.Black
            1-> Color.White
            else -> {Color.White}
        },)){}

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = when(pagerState.currentPage){
                0->Color.Black
                1-> Color.White
                else -> {Color.White}
            },
            contentColor = when(pagerState.currentPage){
                0->Color.White
                1-> Color.Black
                else -> {Color.White}
            }
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    text = { Text(text = item.title)},
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
                )
            }
        }
        LaunchedEffect(pagerState.currentPage) {
            darkIconsState.value = when (pagerState.currentPage) {
                0 -> false
                1 -> true
                else -> false
            }
            Log.d("TAG", "HomePage: ${darkIconsState.value}")
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = darkIconsState.value
            )

        }


        HorizontalPager(
            pageCount = tabItems.size,
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> {
                    RecommendPage()
                }
                1 -> {
                    LongVideo()
                }
            }
        }

    }
}

@Preview
@Composable
fun homepage()
{

}