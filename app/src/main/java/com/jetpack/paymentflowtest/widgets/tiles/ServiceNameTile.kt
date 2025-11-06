package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ServiceNameTile(
    label: String = "Name",
    serviceName: String
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
        Row {
            Text(
                text = serviceName.ifEmpty { "Choose a service" },
                style = TextStyle(
                    color = Color(0xFF98A2B3),
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.sp,
                    fontWeight = FontWeight.W400,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                Icons.Rounded.Code,
                contentDescription = "Up Down Chevrons",
                modifier = Modifier
                    .rotate(90f)
                    .size(18.dp),
                tint = Color(0xFF98A2B3)
            )
        }
    }
}