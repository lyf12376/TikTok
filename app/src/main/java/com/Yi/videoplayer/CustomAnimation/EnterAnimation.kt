package com.Yi.videoplayer.CustomAnimation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visibleState = remember { MutableTransitionState(initialState = false) }.apply { targetState = true },
        enter = slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(300)) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(300)) + fadeOut(),
    ) {
        content()
    }
}