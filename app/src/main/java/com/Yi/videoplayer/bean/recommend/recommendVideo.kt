package com.Yi.videoplayer.bean.recommend

import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.comment.comment

data class recommendVideo (
    val author:Author,
    val like:Int,
    val totalComments:Int,
    val comments:List<comment>
)