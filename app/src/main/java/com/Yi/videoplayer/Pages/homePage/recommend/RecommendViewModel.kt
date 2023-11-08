package com.Yi.videoplayer.Pages.homePage.recommend

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(): ViewModel(){
    var like = mutableStateOf(false)
    var likes = mutableStateOf(0)
    var comments = mutableStateOf(0)
    var storage = mutableStateOf(false)
    var storages = mutableStateOf(0)
}