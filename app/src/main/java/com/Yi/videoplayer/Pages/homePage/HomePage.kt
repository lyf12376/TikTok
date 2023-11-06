package com.Yi.videoplayer.Pages.homePage

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.Yi.videoplayer.bean.TabItem
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(paddingValues: PaddingValues)
{
    val tabItems = listOf(
        TabItem(title = "推荐"),
        TabItem(title = "长视频"),
        TabItem(title = "本地")

    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize().padding(paddingValues) ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage
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
                0 -> { Text("推荐", modifier = Modifier.fillMaxSize()) }
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