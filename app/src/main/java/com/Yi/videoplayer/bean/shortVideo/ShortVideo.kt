package com.Yi.videoplayer.bean.shortVideo

import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.comment.Comment

data class ShortVideo (
    val author:Author,
    val introduction : String,
    val like:Int,
    val totalComments:Int,
    val storage:Int,
    val shared:Int,
    val Comments:List<Comment>
)