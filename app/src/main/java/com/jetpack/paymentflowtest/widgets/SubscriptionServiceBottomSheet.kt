package com.jetpack.paymentflowtest.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.paymentflowtest.R
import kotlinx.coroutines.launch

data class SubscriptionServiceItem(
    val name: String,
    val price: Double,
    val icon: Painter
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionServiceBottomSheet(
    subscriptionServiceItem: SubscriptionServiceItem?,
    onSubscriptionServiceItem: (SubscriptionServiceItem?) -> Unit,
    onDismiss: () -> Unit
) {

    var selectedSubscriptionServiceItem by remember { mutableStateOf(subscriptionServiceItem) }
    var query by remember { mutableStateOf("") }
    val subscriptionServiceList = listOf(
        SubscriptionServiceItem(
            name = "Netflix",
            price = 15.0,
            icon = painterResource(R.drawable.netflix)
        ),
        SubscriptionServiceItem(
            name = "Hulu",
            price = 12.99,
            icon = painterResource(R.drawable.hulu)
        ),
        SubscriptionServiceItem(
            name = "Spotify",
            price = 9.99,
            icon = painterResource(R.drawable.spotify)
        ),
        SubscriptionServiceItem(
            name = "PlayStation+",
            price = 14.99,
            icon = painterResource(R.drawable.playstation)
        ),
        SubscriptionServiceItem(
            name = "Paramount+",
            price = 9.99,
            icon = painterResource(R.drawable.paramount)
        ),
        SubscriptionServiceItem(
            name = "YouTube Music",
            price = 10.99,
            icon = painterResource(R.drawable.youtube)
        )
    )
    var filteredItems by remember { mutableStateOf(subscriptionServiceList) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false, // allow partial height
        confirmValueChange = { true }
    )

    val scope = rememberCoroutineScope()

    // Show sheet partially (70%) when opened
    LaunchedEffect(Unit) {
        scope.launch {
            sheetState.partialExpand()
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .width(36.dp)
                    .height(5.dp)
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(2.5.dp))
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.CenterStart // default alignment to start (left)
        ) {
            Text(
                text = "Services",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = Color(0xFF212121),
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    letterSpacing = 0.sp,
                    fontWeight = FontWeight.Medium,
                ),
                textAlign = TextAlign.Center
            )
            TextButton(
                onClick = {
                    onSubscriptionServiceItem(selectedSubscriptionServiceItem)
                    onDismiss()
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Text(
                    "Done",
                    color = Color(0xFF0066FF),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        FancySearchTextField(
            value = query,
            onValueChange = {
                query = it
                filteredItems = if (it.isBlank()) {
                    subscriptionServiceList
                } else {
                    subscriptionServiceList.filter { item ->
                        item.name.contains(it, ignoreCase = true)
                    }
                }
            },
            placeholder = "Search",
            modifier = Modifier
        )
        // Features List
        if (filteredItems.isNotEmpty()) {
            LazyColumn(state = rememberLazyListState(), modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(items = filteredItems) { index, item ->
                    SubscriptionServiceItemRow(
                        isChecked = item.name == selectedSubscriptionServiceItem?.name,
                        icon = item.icon,
                        label = item.name,
                        modifier = Modifier.clickable {
                            selectedSubscriptionServiceItem = item
                        }
                    )
                    if (index != subscriptionServiceList.size - 1) {
                        Divider(
                            thickness = 1.dp,
                            color = Color(0xFFE3E6EB),
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                        )
                    }
                }
            }
        } else {
            Text(
                text = "No Services Found",
                style = TextStyle(
                    color = Color(0xFF636A79),
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.sp,
                    fontWeight = FontWeight.W400,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun SubscriptionServiceItemRow(
    isChecked: Boolean = false,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    label: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Image(
                    it,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(30.dp),
                )
            }
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF1C1E22),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            )
        }
        Box(
            modifier = Modifier.padding(end = 16.dp)
        ) {
            CommonCheckbox(
                isChecked = isChecked,
            )
        }
    }
}

@Composable
fun FancySearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Search",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .background(Color.Transparent)
            .padding(4.dp) // space for outer light-blue border
    ) {
        // Outer border
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent, RoundedCornerShape(14.dp))
                .border(
                    width = 3.dp,
                    color = Color(0xFFCCD5FF), // light blue outer stroke
                    shape = RoundedCornerShape(14.dp)
                )
        )

        // Inner border + content
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(2.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF002FFF), // blue border
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                // 🔍 Leading search icon
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF667085),
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // 📝 TextField
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = Color(0xFF667085),
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
