package com.Yi.videoplayer.Pages.homePage.recommend

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.Yi.videoplayer.network.VideoService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class recommendViewModel @Inject constructor(): ViewModel(){
    var like = mutableStateOf(false)
}