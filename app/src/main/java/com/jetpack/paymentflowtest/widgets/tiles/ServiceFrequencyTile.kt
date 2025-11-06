package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.ui.theme.TextPlaceholder
import com.jetpack.paymentflowtest.ui.theme.TextPrimary

@Composable
fun ServiceFrequencyTile(
    label: String = "Frequency",
    selectedFrequency: String,
    onFrequencyClick: () -> Unit
) {
    BaseTile(
        label = label,
        onClick = onFrequencyClick
    ) {
        Row {
            Text(
                text = selectedFrequency.ifEmpty { "Choose frequency" },
                style = MaterialTheme.typography.bodyMedium,
                color = if (selectedFrequency.isEmpty()) TextPlaceholder else TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                Icons.Rounded.Code,
                contentDescription = "Dropdown",
                modifier = Modifier
                    .rotate(90f)
                    .size(18.dp),
                tint = TextPlaceholder
            )
        }
    }
}