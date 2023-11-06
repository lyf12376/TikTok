package com.Yi.videoplayer.Frame

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.Yi.videoplayer.Pages.ScreenData
import com.Yi.videoplayer.navigation.NavigationGraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFrame() {
    val navHostController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {  BottomBar(navHostController, modifier = Modifier.navigationBarsPadding()) },
            modifier = Modifier.fillMaxSize()
        ) {
            NavigationGraph(navHostController = navHostController, paddingValues = it)
        }
    }
}

