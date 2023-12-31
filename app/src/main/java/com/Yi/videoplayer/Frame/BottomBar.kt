package com.Yi.videoplayer.Frame

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.Yi.videoplayer.Pages.login.noRippleClickable
import com.Yi.videoplayer.R
import com.Yi.videoplayer.navigation.Screen
import com.Yi.videoplayer.utils.isNavigationExist

@Composable
fun BottomBar(navHostController: NavController, modifier: Modifier) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var selected by remember {
        mutableStateOf(1)
    }
    var color by remember {
        mutableStateOf(Color.Black)
    }
    color = if (currentRoute == Screen.HomePage.route || currentRoute == Screen.FriendsPage.route) Color.Black else Color.White
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(color)
    ) {
        BottomBarItem(
            text = "首页",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .noRippleClickable  {
                    selected = 1
                    navHostController.navigate(Screen.HomePage.route)
                },
            selected = selected == 1,
            color = if (color == Color.Black) Color.White else Color.Black
        )
        BottomBarItem(
            text = "朋友",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .noRippleClickable  {
                    selected = 2
                    navHostController.navigate(Screen.FriendsPage.route)
                },
            selected = selected == 2,
            color = if (color == Color.Black) Color.White else Color.Black
        )
        BottomBarItem(
            text = "消息",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .noRippleClickable {
                    selected = 3
                    navHostController.navigate(Screen.MessagePage.route)
                },
            selected = selected == 3,
            color = if (color == Color.Black) Color.White else Color.Black
        )
        BottomBarItem(
            text = "我的",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .noRippleClickable {
                    selected = 4
                    navHostController.navigate(Screen.MinePage.route)
                },
            selected = selected == 4,
            color = if (color == Color.Black) Color.White else Color.Black
        )
    }


}

@Composable
fun BottomBarItem(text: String, modifier: Modifier, selected: Boolean = false, color: Color) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.cute)),
            fontSize = if (selected) 20.sp else 18.sp,
            color = color,
            fontWeight = if (selected)FontWeight.Bold else FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun BottomAppBarPreview() {

}