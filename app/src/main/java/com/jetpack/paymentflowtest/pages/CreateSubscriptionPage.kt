package com.jetpack.paymentflowtest.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.paymentflowtest.widgets.ChooseAService
import com.jetpack.paymentflowtest.widgets.Header
import com.jetpack.paymentflowtest.widgets.SubscriptionServiceBottomSheet
import com.jetpack.paymentflowtest.widgets.SubscriptionServiceItem
import com.jetpack.paymentflowtest.widgets.pickers.CategoryItem
import com.jetpack.paymentflowtest.widgets.pickers.CategoryPicker
import com.jetpack.paymentflowtest.widgets.pickers.DatePicker
import com.jetpack.paymentflowtest.widgets.pickers.FrequencyPicker
import com.jetpack.paymentflowtest.widgets.tiles.ServiceActiveTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceDateTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceFrequencyTile
import java.util.Date

@Composable
fun CreateSubscriptionPage(onClose: () -> Unit) {
    val bg = Color(0xFFF4F5F7)

    val cardShape = RoundedCornerShape(16.dp)

    var selectedService by remember { mutableStateOf<SubscriptionServiceItem?>(null) }
    val frequencies = listOf("Weekly", "Monthly", "Yearly")

    var selectedDate by remember { mutableStateOf(Date()) }
    var selectedFrequency by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<CategoryItem?>(null) }

    var showServicePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showFrequencyPicker by remember { mutableStateOf(false) }
    var showCategoryPicker by remember { mutableStateOf(false) }
    var isSubscriptionActive by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(horizontal = 16.dp)
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.height(56.dp))
            Header(onClose = onClose, isServiceSelected = selectedService != null)

            Spacer(Modifier.height(20.dp))

            ChooseAService(selectedService = selectedService, onTap = {
                showServicePicker = true
            })

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
                        Row(
                            modifier = Modifier.clickable {
                                showServicePicker = true
                            }
                        ) {
                            Text(
                                text = selectedService?.name ?: "Choose a service",
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
                            text = "$${selectedService?.price ?: '0'}",
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
                    ServiceDateTile(
                        label = "Start Date",
                        selectedDate = selectedDate,
                        onDateClick = { showDatePicker = true }
                    )

                    // service frequency card
                    ServiceFrequencyTile(
                        label = "Frequency",
                        selectedFrequency = selectedFrequency,
                        onFrequencyClick = { showFrequencyPicker = true }
                    )

                    // service active card
                    ServiceActiveTile(
                        label = "Active",
                        isActive = isSubscriptionActive,
                        onActiveChange = { isSubscriptionActive = it }
                    )
                }
            }
        }
    }

    if (showDatePicker) {
        DatePicker(
            currentDate = selectedDate,
            onDateSelected = { date -> selectedDate = date },
            onDismiss = { showDatePicker = false }
        )
    }

    if (showFrequencyPicker) {
        FrequencyPicker(
            frequencies = frequencies,
            selectedFrequency = selectedFrequency,
            frequencySelected = {
                selectedFrequency = it
            },
            onDismiss = { showFrequencyPicker = false }
        )
    }

    if (showCategoryPicker) {
        CategoryPicker(
            selectedCategory = selectedCategory,
            categorySelected = {
                selectedCategory = it
            },
            onDismiss = { showCategoryPicker = false }
        )
    }

    if (showServicePicker) {
        SubscriptionServiceBottomSheet(
            subscriptionServiceItem = selectedService,
            onSubscriptionServiceItem = {
                selectedService = it
            },
            onDismiss = { showServicePicker = false }
        )
    }
}
