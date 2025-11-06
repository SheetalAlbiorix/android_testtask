package com.jetpack.paymentflowtest.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpack.paymentflowtest.widgets.ChooseAService
import com.jetpack.paymentflowtest.widgets.Header
import com.jetpack.paymentflowtest.widgets.ServiceCard
import com.jetpack.paymentflowtest.widgets.pickers.ServicePicker
import com.jetpack.paymentflowtest.widgets.pickers.ServiceItem
import com.jetpack.paymentflowtest.widgets.pickers.CategoryItem
import com.jetpack.paymentflowtest.widgets.pickers.CategoryPicker
import com.jetpack.paymentflowtest.widgets.pickers.DatePicker
import com.jetpack.paymentflowtest.widgets.pickers.FrequencyPicker
import com.jetpack.paymentflowtest.widgets.tiles.ServiceActiveTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceAmountTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceCategoryTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceDateTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceFrequencyTile
import com.jetpack.paymentflowtest.widgets.tiles.ServiceNameTile
import java.util.Date

@Composable
fun CreateSubscriptionPage(onClose: () -> Unit) {
    var selectedService by remember { mutableStateOf<ServiceItem?>(null) }
    var selectedDate by remember { mutableStateOf(Date()) }
    var selectedFrequency by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<CategoryItem?>(null) }
    var isActive by remember { mutableStateOf(false) }

    var showServicePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showFrequencyPicker by remember { mutableStateOf(false) }
    var showCategoryPicker by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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

            ServiceCard {
                ServiceNameTile(
                    serviceName = selectedService?.name ?: "Choose a service",
                    onClick = { showServicePicker = true },
                )

                ServiceAmountTile(amount = "${selectedService?.price ?: '0'}")

                ServiceCategoryTile(
                    selectedCategory = selectedCategory,
                    onCategoryClick = { showCategoryPicker = true }
                )
            }


            Spacer(Modifier.height(20.dp))

            ServiceCard {
                ServiceDateTile(
                    selectedDate = selectedDate,
                    onDateClick = { showDatePicker = true }
                )

                ServiceFrequencyTile(
                    selectedFrequency = selectedFrequency,
                    onFrequencyClick = { showFrequencyPicker = true }
                )

                ServiceActiveTile(
                    isActive = isActive,
                    onActiveChange = { isActive = it }
                )
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
        ServicePicker(
            serviceItem = selectedService,
            onServiceItem = {
                selectedService = it
            },
            onDismiss = { showServicePicker = false }
        )
    }
}
