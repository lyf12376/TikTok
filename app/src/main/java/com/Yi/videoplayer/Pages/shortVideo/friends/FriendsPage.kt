package com.Yi.videoplayer.Pages.shortVideo.friends

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.Yi.videoplayer.bean.TabItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FriendsPage(paddingValues: PaddingValues) {

    val tabItems = listOf(
        TabItem(title = "添加"),
        TabItem(title = "动态"),
    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        TabRow(
            selectedTabIndex = pagerState.currentPage
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    text = { Text(text = item.title) },
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
                )
            }
        }

        HorizontalPager(
            pageCount = tabItems.size,
            state = pagerState,
        ) { page ->
            Text(tabItems[page].title, modifier = Modifier.fillMaxSize())
        }

    }
}

@Preview
@Composable
fun fr(){
    FriendsPage(paddingValues = PaddingValues(8.dp))
}