package com.jetpack.paymentflowtest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.paymentflowtest.widgets.ChooseAService
import com.jetpack.paymentflowtest.widgets.DatePickerBottomSheet
import com.jetpack.paymentflowtest.widgets.DatePickerCard
import com.jetpack.paymentflowtest.widgets.FrequencyCard
import com.jetpack.paymentflowtest.widgets.FrequencyPickerBottomSheet
import com.jetpack.paymentflowtest.widgets.Header
import java.util.Date

@Composable
fun CreateSubscription(onClose: () -> Unit) {
    val bg = Color(0xFFF4F5F7)

    val cardShape = RoundedCornerShape(16.dp)

    var serviceName by remember { mutableStateOf("") }
    var serviceImage by remember { mutableStateOf("") }
    var serviceAmount by remember { mutableStateOf("0") }

    var selectedCategory by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf(Date()) }
    var selectedFrequency by remember { mutableStateOf("") }

    var showServicePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showFrequencyPicker by remember { mutableStateOf(false) }
    var showCategoryPicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("Apr 12, 2025") }
    var selectedFrequency by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<CategoryItem?>(null) }
    var isSubscriptionActive by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(horizontal = 16.dp)
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.height(56.dp))
            Header(onClose = onClose)

            Spacer(Modifier.height(20.dp))

            ChooseAService(amount = serviceAmount)

            Spacer(Modifier.height(20.dp))

            //region Service Price
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 180.dp),
                shape = cardShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.fillMaxWidth()) {
                    //region Choose Service
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Name",
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
                                text = "Choose a service",
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
                    //endregion
                    // region Service Amount
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Amount",
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
                        Text(
                            text = "$0",
                            style = TextStyle(
                                color = Color(0xFF212121),
                                fontSize = 16.sp,
                                lineHeight = 22.sp,
                                letterSpacing = 0.sp,
                                fontWeight = FontWeight.W400,
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    //endregion
                    // region Service Category
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Category",
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
                        Row(
                            modifier = Modifier.clickable {
                                showCategoryPicker = true
                            }
                        ) {
                            if (selectedCategory != null) {
                                selectedCategory?.imageVector?.let {
                                    Icon(
                                        it,
                                        contentDescription = selectedCategory?.label
                                    )
                                }
                                selectedCategory?.label?.let {
                                    Text(
                                        text = it,
                                        style = TextStyle(
                                            color = Color(0xFF212121),
                                            fontSize = 16.sp,
                                            lineHeight = 22.sp,
                                            letterSpacing = 0.sp,
                                            fontWeight = FontWeight.W400,
                                        ),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            } else {
                                Text(
                                    text = "Choose a category",
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
                            }
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
                    //endregion
                }
            }
            //endregion
            Spacer(Modifier.height(20.dp))
            //region Service Date Frequency
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 180.dp),
                shape = cardShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.fillMaxWidth()) {
                    //region Start Date
                    DatePickerCard(
                        label = "Start Date",
                        selectedDate = selectedDate,
                        onDateClick = { showDatePicker = true }
                    )
                    //endregion
                    // region Frequency
                    FrequencyCard(
                        label = "Frequency",
                        selectedFrequency = selectedFrequency,
                        onFrequencyClick = { showCategoryPicker = true }
                    )
                    //endregion
                    // region Service Active
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Active",
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
                            checked = isSubscriptionActive,
                            onCheckedChange = {
                                isSubscriptionActive = it
                            },
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
                            modifier = Modifier
                                .scale(0.8f)
                                .align(Alignment.CenterVertically)
                        )
                    }
                    //endregion
                }
            }
            //endregion
        }
    }
    if (showDatePicker) {
        DatePickerBottomSheet(
            currentDate = selectedDate,
            onDateSelected = { date -> selectedDate = date },
            onDismiss = { showDatePicker = false }
        )
    }

    if (showFrequencyPicker) {
        FrequencyPickerBottomSheet(
            selectedFrequency = selectedFrequency,
            frequencySelected = {
                selectedFrequency = it
            },
            onDismiss = { showFrequencyPicker = false }
        )
    }

    if (showCategoryPicker) {
        CategoryPickerBottomSheet(
            selectedCategory = selectedCategory,
            categorySelected = {
                selectedCategory = it
            },
            onDismiss = { showCategoryPicker = false }
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerBottomSheet(
    initialMonth: Int = 9, // September
    initialDay: Int = 17,
    initialYear: Int = 2021,
    onDateSelected: (month: Int, day: Int, year: Int) -> Unit,
    onDismiss: () -> Unit
) {
    var selectedMonth by remember { mutableStateOf(initialMonth) }
    var selectedDay by remember { mutableStateOf(initialDay) }
    var selectedYear by remember { mutableStateOf(initialYear) }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            // Header

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                contentAlignment = Alignment.CenterStart // default alignment to start (left)
            ) {
                Text(
                    text = "Start Date",
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
                        onDateSelected(selectedMonth, selectedDay, selectedYear)
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
            // Date Picker Wheels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                WheelDatePicker(modifier = Modifier.fillMaxWidth()) { snappedDate ->
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        selectedMonth = snappedDate.monthValue
                        selectedDay = snappedDate.dayOfMonth
                        selectedYear = snappedDate.year
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrequencyPickerBottomSheet(
    selectedFrequency: String,
    frequencySelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var frequency by remember { mutableStateOf(selectedFrequency) }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
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
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.CenterStart // default alignment to start (left)
        ) {
            Text(
                text = "Frequency",
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
                    frequencySelected(frequency)
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

        // Features List
        FeatureRow(
            label = "Weekly",
            modifier = Modifier.clickable {
                frequency = "Weekly"
            },
            isChecked = frequency == "Weekly"
        )

        Divider(
            thickness = 1.dp,
            color = Color(0xFFE3E6EB),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )

        FeatureRow(
            label = "Monthly",
            modifier = Modifier.clickable {
                frequency = "Monthly"
            },
            isChecked = frequency == "Monthly"
        )

        Divider(
            thickness = 1.dp,
            color = Color(0xFFE3E6EB),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )

        FeatureRow(
            label = "Annually",
            modifier = Modifier.clickable {
                frequency = "Annually"
            },
            isChecked = frequency == "Annually"
        )

        Spacer(Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryPickerBottomSheet(
    selectedCategory: CategoryItem?,
    categorySelected: (CategoryItem?) -> Unit,
    onDismiss: () -> Unit
) {
    var category by remember { mutableStateOf(selectedCategory) }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
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
        val categoryList = listOf(
            CategoryItem(
                imageVector = Icons.Rounded.Cached,
                label = "Subscription",
            ), CategoryItem(
                imageVector = Icons.Rounded.Build,
                label = "Utility",
            ), CategoryItem(
                imageVector = Icons.Rounded.CreditCard,
                label = "Card Payment",
            ), CategoryItem(
                imageVector = Icons.Rounded.MonetizationOn,
                label = "Loan",
            ), CategoryItem(
                imageVector = Icons.Rounded.Home,
                label = "Rent",
            )
        )
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.CenterStart // default alignment to start (left)
        ) {
            Text(
                text = "Frequency",
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
                    categorySelected(category)
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

        // Features List
        LazyColumn(state = rememberLazyListState(), modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(items = categoryList) { index, item ->
                FeatureRow(
                    isChecked = item.label == category?.label,
                    icon = item.imageVector,
                    label = item.label,
                    modifier = Modifier.clickable {
                        category = item
                    }
                )
                if (index != categoryList.size - 1) {
                    Divider(
                        thickness = 1.dp,
                        color = Color(0xFFE3E6EB),
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }
        }
        Spacer(Modifier.height(24.dp))
    }
}

data class CategoryItem(
    val imageVector: ImageVector,
    val label: String,
)

@Composable
fun FeatureRow(
    isChecked: Boolean = false,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
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
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF2F4F7))
                ) {
                    Icon(
                        it,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                            .padding(5.dp),
                        tint = Color(0xFF212121)
                    )
                }
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
fun CommonCheckbox(
    isChecked: Boolean,
    size: Float = 24f,
    uncheckedColor: Color = Color.Transparent,
) {
    val checkboxColor: Color by animateColorAsState(if (isChecked) Color(0xFF002FFF) else Color.White)
    val density = LocalDensity.current
    val duration = 200

    Box(
        modifier = Modifier
            .size(size.dp)
            .background(color = checkboxColor, shape = CircleShape)
            .heightIn(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            AnimatedVisibility(
                visible = isChecked,
                enter = slideInHorizontally(animationSpec = tween(duration)) {
                    with(density) { (size * -0.5).dp.roundToPx() }
                } + expandHorizontally(
                    expandFrom = Alignment.Start,
                    animationSpec = tween(duration)
                ),
            ) {
                Icon(
                    Icons.Rounded.Check,
                    contentDescription = null,
                    tint = if (isChecked) Color.White else Color(0xFF002FFF),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
