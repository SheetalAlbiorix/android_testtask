package com.jetpack.paymentflowtest.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    onClose: () -> Unit = {}
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedIconButton(
            onClick = onClose,
            borderColor = Color(0xFFD0D5DD)
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Close",
                tint = Color(0xFF212121)
            )
        }
        Text(
            text = "Create Subscription",
            style = TextStyle(
                color = Color(0xFF212121),
                fontSize = 18.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Medium,
            ),
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Save",
            style = TextStyle(
                color = Color(0xFF98A2B3),
                fontSize = 18.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Medium,
            ),
        )
    }
}

@Composable
private fun OutlinedIconButton(
    onClick: () -> Unit,
    borderColor: Color,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .size(43.dp)
            .clip(CircleShape)
            .background(Color.White)
            .clickable { onClick() }
            .border(width = 1.dp, color = borderColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
