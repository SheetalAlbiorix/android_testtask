package com.jetpack.paymentflowtest.widgets.tiles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.ui.theme.TextPlaceholder
import com.jetpack.paymentflowtest.ui.theme.TextPrimary
import com.jetpack.paymentflowtest.ui.theme.TextSecondary

/**
 * Common styles and defaults for tile components
 */
object TileDefaults {
    val TileHeight = 60.dp
    val HorizontalPadding = 20.dp
}

/**
 * Base tile component that provides consistent layout and styling
 */
@Composable
fun BaseTile(
    label: String,
    onClick: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(TileDefaults.TileHeight)
            .padding(horizontal = TileDefaults.HorizontalPadding)
            .then(
                if (onClick != null) {
                    Modifier.clickable(onClick = onClick)
                } else {
                    Modifier
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = TextSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        content()
    }
}