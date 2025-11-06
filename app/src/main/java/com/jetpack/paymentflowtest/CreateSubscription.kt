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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
    var showCategoryPicker by remember { mutableStateOf(false) }
    var showFrequencyPicker by remember { mutableStateOf(false) }

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
                        DollarCurrencyTextField(
                            value = serviceAmount,
                            onValueChange = { serviceAmount = it },
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
                        Row {
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
                            checked = false,
                            onCheckedChange = { },
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

    if (showCategoryPicker) {
        FrequencyPickerBottomSheet(
            frequencySelected = { selectedFrequency = it },
            onDismiss = { showCategoryPicker = false }
        )
    }
}

@Composable
fun DollarCurrencyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val minChars = 1
    val charCount = maxOf(value.length, minChars)
    val width = (charCount * 12).dp

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$",
            style = TextStyle(
                color = Color(0xFF212121),
                fontSize = 16.sp,
                lineHeight = 22.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.W400,
            ),
            maxLines = 1,
            textAlign = TextAlign.Center,
        )
        BasicTextField(
            value = value,
            onValueChange = { new ->
                // Allow only digits and one dot, limit to 2 decimals
                val filtered = new
                    .replace("[^0-9.]".toRegex(), "")
                    .let {
                        if (!it.contains('.')) it
                        else {
                            val parts = it.split('.', limit = 2)
                            parts[0] + "." + parts.getOrNull(1).orEmpty().take(2)
                        }
                    }
                onValueChange(filtered)
            },
            modifier = modifier.width(width),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            decorationBox = { innerTextField ->
                Column(
                    Modifier
                ) {
                    innerTextField()
                    // The underline
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color(0xFF212121))
                    )
                }
            }
        )
    }
}
