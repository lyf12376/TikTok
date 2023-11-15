package com.Yi.videoplayer.Pages.homePage

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.Yi.videoplayer.Pages.homePage.recommend.RecommendPage
import com.Yi.videoplayer.bean.TabItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(paddingValues: PaddingValues, homeViewModel: HomeViewModel = hiltViewModel())
{
    val tabItems = listOf(
        TabItem(title = "推荐"),
        TabItem(title = "长视频"),
        TabItem(title = "本地")

    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black))
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color.Black,
            contentColor = Color.White
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    text = { Text(text = item.title)},
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
                )
            }
        }

        HorizontalPager(
            pageCount = tabItems.size,
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> { RecommendPage() }
                1 -> { Text("长视频", modifier = Modifier.fillMaxSize()) }
                2 -> { Text("本地", modifier = Modifier.fillMaxSize()) }
            }
        }

    }
}

@Preview
@Composable
fun homepage()
{

}