package com.Yi.videoplayer.Pages.minePage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Yi.videoplayer.Pages.ScreenData
import com.Yi.videoplayer.Pages.login.noRippleClickable
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.TabItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

//height837.0.dp
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MinePage() {

    val tabItems = listOf(
        TabItem(title = "我的"),
        TabItem(title = "收藏"),

    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
        //.padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        Image(
            painterResource(id = R.drawable.mine_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(Modifier.padding(top = 837.0.dp / 6)) {
            Box {
                Row {
                    //TODO("在这里使用ViewModel获取用户数据")
                    Icon(
                        painterResource(id = R.drawable.add),
                        contentDescription = "头像",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(96.dp),
                        tint = Color.Unspecified
                    )
                    Text(
                        text = "游客",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 28.sp
                    )
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(Color.White)
                ) {
                    Row {
                        //TODO(将数据替换)
                        text(amount = 0, text = "获赞", modifier = Modifier)
                        text(amount = 0, text = "关注", modifier = Modifier)
                        text(amount = 0, text = "粉丝", modifier = Modifier)
                    }
                    Row (Modifier.noRippleClickable {  }){
                        Text(
                            text = "点击添加介绍让大家认识你...",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 20.dp),
                            fontWeight = FontWeight.Light
                        )
                        Icon(
                            painterResource(id = R.drawable.edit),
                            contentDescription = "修改签名",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ) {
                        tabItems.forEachIndexed { index, item ->
                            Tab(
                                text = { Text(text = item.title) },
                                selected = pagerState.currentPage == index,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(
                                            index
                                        )
                                    }
                                }
                            )
                        }
                    }

                    HorizontalPager(
                        pageCount = tabItems.size,
                        state = pagerState,
                    ) { page ->
                        when (page) {
                            0 -> {
                                Text("我的", modifier = Modifier.fillMaxSize())
                            }

                            1 -> {
                                Text("收藏", modifier = Modifier.fillMaxSize())
                            }

                        }
                    }
                }
            }


        }
    }
}

@Composable
fun text(amount: Int, text: String, modifier: Modifier) {
    Box(modifier = Modifier.padding(20.dp)) {
        Row {
            Text(text = "$amount", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = " : $text", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun minePage() {
    MinePage()
}

