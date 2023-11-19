package com.Yi.videoplayer.Pages.shortVideo.homePage.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Yi.videoplayer.bean.shortVideo.ShortVideo
import com.Yi.videoplayer.network.VideoService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(private val service: VideoService):ViewModel(){
    private val shortVideoQueue = ArrayDeque<ShortVideo>()
    fun getVideo(): ShortVideo? {
        if (shortVideoQueue.size < 3) {
            loadMoreVideos()
        }
        return shortVideoQueue.removeFirst()
    }

    private fun loadMoreVideos() {
        viewModelScope.launch {
            val response = service.getVideo() // 调用getVideo函数
            shortVideoQueue.add(response.video)
        }
    }

}