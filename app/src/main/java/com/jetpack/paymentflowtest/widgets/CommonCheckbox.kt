package com.jetpack.paymentflowtest.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun CommonCheckbox(
    isChecked: Boolean,
    size: Float = 24f,
    uncheckedColor: Color = Color.Transparent,
) {
    val checkboxColor: Color by animateColorAsState(if (isChecked) Color(0xFF002FFF) else Color.White)
    val density = LocalDensity.current
    val duration = 200

    Box(
        modifier = Modifier
            .size(size.dp)
            .background(color = checkboxColor, shape = CircleShape)
            .heightIn(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            AnimatedVisibility(
                visible = isChecked,
                enter = slideInHorizontally(animationSpec = tween(duration)) {
                    with(density) { (size * -0.5).dp.roundToPx() }
                } + expandHorizontally(
                    expandFrom = Alignment.Start,
                    animationSpec = tween(duration)
                ),
            ) {
                Icon(
                    Icons.Rounded.Check,
                    contentDescription = null,
                    tint = if (isChecked) Color.White else Color(0xFF002FFF),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}