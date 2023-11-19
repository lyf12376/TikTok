package com.Yi.videoplayer.Pages.shortVideo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShortVideoViewModel @Inject constructor(): ViewModel(){
    var like = mutableStateOf(false)
    var likes = mutableStateOf(0)
    var comments = mutableStateOf(0)
    var storage = mutableStateOf(false)
    var storages = mutableStateOf(0)
}