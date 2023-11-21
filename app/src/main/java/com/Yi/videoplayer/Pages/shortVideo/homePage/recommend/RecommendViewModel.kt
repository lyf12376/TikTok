package com.Yi.videoplayer.Pages.shortVideo.homePage.recommend

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.shortVideo.ShortVideo
import com.Yi.videoplayer.network.VideoService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(private val service: VideoService):ViewModel(){
    private val shortVideoWaitQueue = ArrayDeque<ShortVideo>()
    private val _shortVideoList = MutableStateFlow<MutableList<ShortVideo>>(mutableListOf())
    val shortVideoList: StateFlow<MutableList<ShortVideo>> get() = _shortVideoList

    init {
        val shortVideo1 =
            ShortVideo(
                0,
                "https://v3-web.douyinvod.com/1624b96814a2c170781063b8150bd9ff/65586bf1/video/tos/cn/tos-cn-ve-15c001-alinc2/ownPHDEjSI5Hae6AgNdbQZiy0XvWB9gcelQuAA/?a=6383&ch=5&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=2034&bt=2034&cs=0&ds=3&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiXE5h1FVJEYLy75vPD-I&mime_type=video_mp4&qs=0&rc=NjRmZjtnaTpnaTRoOTlkOUBpampsNDU6ZjlobjMzNGkzM0AyMjUtMGMwNTAxXzE1Xi4vYSMya3E0cjRnNmNgLS1kLWFzcw%3D%3D&btag=e00030000&dy_q=1700289536&feature_id=f0150a16a324336cda5d6dd0b69ed299&l=202311181438558DDA17F69E858D626F6A",
                Author("1", "photo.url"),
                "这是一个测试",
                10,
                false,
                10,
                0,
                false,
                0,
                emptyList()
            )

        val shortVideo2 =
            ShortVideo(
                1,
                "https://v3-web.douyinvod.com/f79d5349c4f83204115f226053224215/65586a1d/video/tos/cn/tos-cn-ve-15c001-alinc2/oYIEOyBAhBwCvgetGFEA9fhAsFzP5pQBXNZYyD/?a=6383&ch=5&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=1283&bt=1283&cs=0&ds=3&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiXE5h1FVJEYLy75vPD-I&mime_type=video_mp4&qs=1&rc=ODU3NGc6NDM1ZTY1PDY6NEBpanNudTk6ZmY0bzMzNGkzM0A2MGBfLTU0Xi4xMTBfXy8uYSNgMDVfcjQwYDRgLS1kLTBzcw%3D%3D&btag=e00008000&dy_q=1700289536&feature_id=46a7bb47b4fd1280f3d3825bf2b29388&l=202311181438558DDA17F69E858D626F6A",
                Author("2", "photo.url"),
                "这是一个测试",
                5,
                true,
                11,
                0,
                false,
                0,
                emptyList()
            )

        val shortVideo3 =
            ShortVideo(
                2,
                "https://v26-web.douyinvod.com/56a624f8c3a6ee6943e804fd61664aaf/655878c7/video/tos/cn/tos-cn-ve-15c001-alinc2/oEasOffbgwADRAIN4JcQZDHeEeBqYseNpC7BA2/?a=6383&ch=26&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=1711&bt=1711&cs=0&ds=6&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiX~7g1FVJEYLy75vPD-I&mime_type=video_mp4&qs=12&rc=OTdnaGlmNDlnNWlpNDQzZUBpM2d4bjY6Zjk7bjMzNGkzM0AvNjZjX2ItXjUxNjQwL18vYSNrai9tcjRvMWdgLS1kLS9zcw%3D%3D&btag=e00038000&dy_q=1700292541&feature_id=46a7bb47b4fd1280f3d3825bf2b29388&l=2023111815290136AAC805344E288B8999",
                Author("3", "photo.url"),
                "这是一个测试",
                5,
                true,
                11,
                0,
                false,
                0,
                emptyList()
            )

        val shortVideo4 =
            ShortVideo(
                3,
                "https://v3-web.douyinvod.com/35300bb33c5d558b0cf1826d18726c79/65587b23/video/tos/cn/tos-cn-ve-15c001-alinc2/oEteIA1oSOxxTR5qRRBoE7xdgSfSAyANdVzDth/?a=6383&ch=224&cr=3&dr=0&lr=all&cd=0%7C0%7C0%7C3&cv=1&br=906&bt=906&cs=0&ds=4&ft=bvTKJbQQqUYSfJ.Zao0OW_EklpPiXccg1FVJEYLy75vPD-I&mime_type=video_mp4&qs=0&rc=MzQ6NjQ4M2dkOTk0OTs6OEBpM2s4aGg6ZnJ1bTMzNGkzM0AtYi41L18vNl4xLzZhXzRjYSM2XmJocjRvaWhgLS1kLTBzcw%3D%3D&btag=e00038000&dy_q=1700292590&feature_id=f0150a16a324336cda5d6dd0b69ed299&l=2023111815294958CCEF54F7129C72C76B",
                Author("4", "photo.url"),
                "这是一个测试",
                5,
                true,
                11,
                0,
                false,
                0,
                emptyList()
            )
        _shortVideoList.value.add(shortVideo1)
        _shortVideoList.value.add(shortVideo2)
        _shortVideoList.value.add(shortVideo3)
        _shortVideoList.value.add(shortVideo4)
    }

    fun getVideo() {
        if (shortVideoWaitQueue.size < 3) {
            loadMoreVideos()
        }
        _shortVideoList.value.add(shortVideoWaitQueue.removeFirst())
    }

    private fun loadMoreVideos() {
        viewModelScope.launch {
            val response = service.getVideo() // 调用getVideo函数
            shortVideoWaitQueue.add(response.video)
        }
    }

    fun updateVideo(index:Int, shortVideo: ShortVideo){
        val newList = _shortVideoList.value.toMutableList()
        Log.d("TAG", "updateVideo: ${newList.size}")
        newList[index] = shortVideo
        Log.d("TAG", "updateVideo: $newList")
        _shortVideoList.value = newList
        Log.d("TAG", "updateVideo: ${_shortVideoList.value.size}")
        //TODO{联网数据更新}

    }
}
