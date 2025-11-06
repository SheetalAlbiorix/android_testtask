package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.ui.theme.SurfaceVariant
import com.jetpack.paymentflowtest.ui.theme.TextPrimary
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ServiceDateTile(
    label: String = "Start Date",
    selectedDate: Date,
    onDateClick: () -> Unit
) {
    val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
    val formattedDate = dateFormat.format(selectedDate)

    BaseTile(
        label = label,
        onClick = onDateClick
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .background(SurfaceVariant)
        ) {
            Text(
                text = formattedDate,
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
            )
        }
    }
}