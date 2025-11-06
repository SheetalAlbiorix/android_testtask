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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.ui.theme.TextPlaceholder
import com.jetpack.paymentflowtest.ui.theme.TextPrimary
import com.jetpack.paymentflowtest.widgets.pickers.CategoryItem

@Composable
fun ServiceCategoryTile(
    label: String = "Category",
    selectedCategory: CategoryItem?,
    onCategoryClick: () -> Unit
) {
    BaseTile(
        label = label,
        onClick = onCategoryClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (selectedCategory != null) {
                Icon(
                    selectedCategory.imageVector,
                    contentDescription = selectedCategory.label,
                    tint = TextPrimary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = selectedCategory.label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            } else {
                Text(
                    text = "Choose a category",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPlaceholder,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
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