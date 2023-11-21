package com.Yi.videoplayer.bean.shortVideo

import com.Yi.videoplayer.bean.author.Author
import com.Yi.videoplayer.bean.comment.Comment

data class ShortVideo (
    val id:Int,
    val address : String,
    val author:Author,
    val introduction : String,
    val like:Int,
    val isLike: Boolean,
    val totalComments:Int,
    val storage:Int,
    val isStorage: Boolean,
    val shares:Int,
    val comments:List<Comment>
)