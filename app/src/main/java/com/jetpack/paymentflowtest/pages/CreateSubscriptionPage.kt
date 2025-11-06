package com.jetpack.paymentflowtest.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.widgets.tiles.ServiceCategoryTile
import com.jetpack.paymentflowtest.widgets.pickers.CategoryItem
import com.jetpack.paymentflowtest.widgets.pickers.CategoryPicker
import com.jetpack.paymentflowtest.widgets.ChooseAService
import com.jetpack.paymentflowtest.widgets.pickers.DatePicker
import com.jetpack.paymentflowtest.widgets.tiles.ServiceDateTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceFrequencyTile
import com.jetpack.paymentflowtest.widgets.pickers.FrequencyPicker
import com.jetpack.paymentflowtest.widgets.Header
import com.jetpack.paymentflowtest.widgets.tiles.ServiceActiveTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceAmountTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceNameTile
import java.util.Date

@Composable
fun CreateSubscriptionPage(onClose: () -> Unit) {
    val bg = Color(0xFFF4F5F7)

    val cardShape = RoundedCornerShape(16.dp)

    // Frequency options
    val frequencies = listOf("Weekly", "Monthly", "Yearly")

    var serviceName by remember { mutableStateOf("") }
    var serviceImage by remember { mutableStateOf("") }
    var serviceAmount by remember { mutableStateOf("0") }

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
            Header(onClose = onClose)

            Spacer(Modifier.height(20.dp))

            ChooseAService(amount = serviceAmount)

            Spacer(Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 180.dp),
                shape = cardShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.fillMaxWidth()) {
                    // Choose service card
                    ServiceNameTile(
                        label = "Name",
                        serviceName = serviceName
                    )

                    // service amount card
                    ServiceAmountTile(
                        label = "Amount",
                        amount = serviceAmount
                    )

                    // service category card
                    ServiceCategoryTile(
                        label = "Category",
                        selectedCategory = selectedCategory,
                        onCategoryClick = { showCategoryPicker = true }
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

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
}