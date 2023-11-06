package com.Yi.videoplayer.Pages.friends

import android.util.Log
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.Yi.videoplayer.bean.TabItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FriendsPage(paddingValues: PaddingValues) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp
    Log.d("TAG", "height: $screenHeightDp width: $screenWidthDp")

    val tabItems = listOf(
        TabItem(title = "添加"),
        TabItem(title = "动态"),
    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

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
            when (page) {
                0 -> {
                    Text("添加", modifier = Modifier.fillMaxSize())
                }

                1 -> {
                    Text("动态", modifier = Modifier.fillMaxSize())
                }
            }
        }

    }
}