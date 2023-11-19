package com.Yi.videoplayer.di

import android.app.Application
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ExoPlayerModule {
    @Provides
    @ViewModelScoped
    fun providerExoPlayer(application: Application): ExoPlayer {
        return ExoPlayer.Builder(application).build()
    }
}