package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.jetpack.paymentflowtest.ui.theme.TextPrimary

@Composable
fun ServiceAmountTile(
    label: String = "Amount",
    amount: String
) {
    BaseTile(label = label) {
        Text(
            text = "$$amount",
            style = MaterialTheme.typography.bodyMedium.copy(
                textDecoration = TextDecoration.Underline
            ),
            color = TextPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}