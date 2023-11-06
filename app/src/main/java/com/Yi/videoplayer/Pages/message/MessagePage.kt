package com.Yi.videoplayer.Pages.message

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.Yi.videoplayer.R
import com.Yi.videoplayer.bean.friends.Friend
import com.Yi.videoplayer.utils.isNavigationExist


@Composable
fun MessagePage(paddingValues: PaddingValues) {
    val list = listOf(
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
        Friend(R.drawable.add, "123"),
        Friend(R.drawable.camera, " 456"),
    )
    Log.d("TAG1", "MessagePage: $paddingValues")
    Log.d("TAG", "MessagePage: ${paddingValues.calculateBottomPadding()}")

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        TopBar()
        friendRow(list)
        friendColumn(list)
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
            Icon(
                painterResource(id = R.drawable.add),
                contentDescription = "添加",
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Icon(painterResource(id = R.drawable.camera), contentDescription = "摄影")
        }
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {
            Icon(
                painterResource(id = R.drawable.search),
                contentDescription = "搜索",
                modifier = Modifier.padding(end = 8.dp)
            )
        }

    }
}

@Composable
fun friendRow(list: List<Friend>) {
    LazyRow {
        for (friend in list) {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Icon(
                        painterResource(id = friend.photo),
                        contentDescription = "${friend.name}",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "${friend.name}",
                        fontFamily = FontFamily(Font(R.font.cute)),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Composable
fun friendColumn(list: List<Friend>) {
    LazyColumn {
        list.forEach {
            item {
                Row(modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()) {
                    Icon(
                        painterResource(id = it.photo),
                        contentDescription = "${it.name}",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 12.dp)
                    )
                    Text(
                        text = "${it.name}",
                        fontFamily = FontFamily(Font(R.font.cute)),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun messagePage() {

}