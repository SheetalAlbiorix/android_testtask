package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ServiceActiveTile(
    label: String = "Active",
    isActive: Boolean,
    onActiveChange: (Boolean) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = TextStyle(
                color = Color(0xFF636A79),
                fontSize = 16.sp,
                lineHeight = 22.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.W400,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Switch(
            checked = isActive,
            onCheckedChange = onActiveChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = Color(0xFF002FFF),
                checkedTrackColor = Color(0xFF002FFF),
                uncheckedTrackColor = Color.Gray,
                checkedBorderColor = Color.Transparent,
                uncheckedBorderColor = Color.Transparent,
            ),
            thumbContent = {
                Box(
                    modifier = Modifier.size(16.dp)
                )
            },
            modifier = Modifier.scale(0.8f)
        )
    }
}