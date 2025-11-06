package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.ui.theme.Gray
import com.jetpack.paymentflowtest.ui.theme.LightGray

@Composable
fun ServiceActiveTile(
    label: String = "Active",
    isActive: Boolean,
    onActiveChange: (Boolean) -> Unit
) {
    BaseTile(label = label) {
        Switch(
            checked = isActive,
            onCheckedChange = onActiveChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                uncheckedThumbColor = Color.White,
                checkedTrackColor = LightGray,
                uncheckedTrackColor = Gray,
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