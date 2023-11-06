package com.Yi.videoplayer.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.Yi.videoplayer.Pages.friends.FriendsPage
import com.Yi.videoplayer.Pages.homePage.HomePage
import com.Yi.videoplayer.Pages.message.MessagePage
import com.Yi.videoplayer.Pages.minePage.MinePage

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    startDestination: String = Screen.HomePage.route,
    paddingValues: PaddingValues
){
    NavHost(navController = navHostController, startDestination = startDestination){
        composable(Screen.HomePage.route){
            HomePage(paddingValues)
        }
        composable(Screen.FriendsPage.route){
            FriendsPage(paddingValues)
        }
        composable(Screen.MessagePage.route){
            MessagePage(paddingValues)
        }
        composable(Screen.MinePage.route){
            MinePage()
        }
    }
}
