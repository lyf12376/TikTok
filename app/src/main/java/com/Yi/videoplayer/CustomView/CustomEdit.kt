package com.Yi.videoplayer.CustomView

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomEdit(
    text: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    hint: String = "请输入",
    @DrawableRes startIcon: Int = -1,
    iconSpacing: Dp = 6.dp,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    cursorBrush: Brush = SolidColor(Color.Black)
) {
    // 焦点, 用于控制是否显示 右侧叉号
    var hasFocus by remember { mutableStateOf(false) }

    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.onFocusChanged { hasFocus = it.isFocused },
        singleLine = true,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        cursorBrush = cursorBrush,
        decorationBox = @Composable { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // -1 不显示 左侧Icon
                if(startIcon != -1){
                    Image(painter = painterResource(id = startIcon), contentDescription = null)
                    Spacer(modifier = Modifier.width(iconSpacing))
                }

                Box(modifier = Modifier.weight(1f)){
                    // 当空字符时, 显示hint
                    if(text.isEmpty())
                        Text(text = hint, color = Color.Gray, style = textStyle)

                    // 原本输入框的内容
                    innerTextField()
                }

                // 存在焦点 且 有输入内容时. 显示叉号
                if(hasFocus && text.isNotEmpty()) {
                    Image(imageVector = Icons.Filled.Clear, // 清除图标
                        contentDescription = null,
                        // 点击就清空text
                        modifier = Modifier.clickable { onValueChange.invoke("") })
                }
            }
        }
    )
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    placeholderText: String = "",
    onTextLayout: (TextLayoutResult) -> Unit = {},
    cursorBrush: Brush = SolidColor(Color.Black),
) {
    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        maxLines = maxLines,
        enabled = enabled,
        readOnly = readOnly,
        interactionSource = interactionSource,
        textStyle = TextStyle(Color.White, fontSize = 18.sp),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        onTextLayout = onTextLayout,
        cursorBrush = cursorBrush,
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (value.isEmpty())
                        Text(
                            placeholderText,
                            style = TextStyle(Color.White, fontSize = 18.sp),
                        )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}

