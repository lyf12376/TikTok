//package com.Yi.videoplayer.Pages.homePage
//
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.drawWithContent
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.Yi.videoplayer.CustomView.CustomEdit
//import com.Yi.videoplayer.CustomView.CustomTextField
//import com.Yi.videoplayer.R
//
//@Composable
//fun TopBar()
//{
//    var search by remember {
//        mutableStateOf("")
//    }
//    Row (modifier = Modifier.fillMaxWidth()){
//        Icon(painterResource(id = R.drawable.bear),
//            contentDescription = "头像",
//            modifier = Modifier
//                .size(64.dp)
//                .padding(8.dp)
//                .clip(CircleShape),
//            tint = Color.Unspecified
//        )
//        BasicTextField(
//            value = search,
//            onValueChange = { search = it },
//            modifier = Modifier
//                .align(Alignment.CenterVertically)
//                .weight(1f)
//                .height(40.dp)
//                .background(Color.Transparent)
//                .padding(start = 16.dp, end = 16.dp)
//                .border(2.dp, color = Color(R.color.unSelected), shape = RoundedCornerShape(32.dp)),
//            textStyle = TextStyle(Color.White, fontSize = 18.sp),
//            singleLine = true,
//            decorationBox = { innerTextField ->
//                Row (modifier = Modifier.fillMaxWidth()){
//                    Icon(
//                        painterResource(id = R.drawable.search),
//                        contentDescription = "密码",
//                        tint = Color.Unspecified,
//                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp)
//                    )
//                    Spacer(modifier = Modifier.width(16.dp))
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .weight(1f),
//                        contentAlignment = Alignment.CenterStart // 水平和竖直居中
//                    ) {
//                        innerTextField() // 确保innerTextField在布局中占据了足够的空间
//                    }
//                }
//            }
//        )
//    }
//}
//
//@Preview
//@Composable
//fun TopBarPreview()
//{
//    TopBar()
//}