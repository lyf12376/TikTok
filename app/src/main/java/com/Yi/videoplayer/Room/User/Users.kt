package com.Yi.videoplayer.Room.User

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Users (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val account:String,
    val password:String,
    val name:String,
    val photo:String,
    var gender:String
)

