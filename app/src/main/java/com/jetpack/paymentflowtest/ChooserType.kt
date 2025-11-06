package com.jetpack.paymentflowtest

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class ChooserType {
    SERVICE,
    CATEGORY,
    DATE,
    FREQUENCY,
}

sealed class ChooserData<T>(
    val type: ChooserType,
    val title: String,
    val options: List<T> = listOf(),
    val selectedOption: Any? = null,
    val hasSearch: Boolean = false,
) {
    data object ServiceData : ChooserData<ChooserOption.ServiceOption>(
        type = ChooserType.SERVICE,
        title = "Services",
        options = listOf(
            ChooserOption.ServiceOption(id = "1", name = "Netflix", image = "netflix_logo_url"),
            ChooserOption.ServiceOption(id = "2", name = "Amazon Prime", image = "prime_logo_url")
        ),
        hasSearch = true,
    )

    data object CategoryData : ChooserData<ChooserOption.CategoryOption>(
        type = ChooserType.CATEGORY,
        title = "Category",
        options = listOf(
            ChooserOption.CategoryOption(
                id = "1",
                name = "Subscription",
                icon = Icons.Default.Refresh
            ),
            ChooserOption.CategoryOption(id = "2", name = "Utility", icon = Icons.Default.Settings),
            ChooserOption.CategoryOption(
                id = "3",
                name = "Card Payment",
                icon = Icons.Default.Settings
            ),
            ChooserOption.CategoryOption(id = "4", name = "Loan", icon = Icons.Default.Settings),
            ChooserOption.CategoryOption(id = "5", name = "Rent", icon = Icons.Default.Settings),
        ),
        selectedOption = "1",
    )

    data object DateData : ChooserData<Long>(
        type = ChooserType.DATE,
        title = "Start Date",
    )

    data object FrequencyData : ChooserData<ChooserOption.FrequencyOption>(
        type = ChooserType.FREQUENCY,
        title = "Frequency",
        options = listOf(
            ChooserOption.FrequencyOption(id = "1", label = "Weekly"),
            ChooserOption.FrequencyOption(id = "2", label = "Monthly"),
            ChooserOption.FrequencyOption(id = "3", label = "Yearly"),

            )
    )
}


sealed class ChooserOption {
    data class ServiceOption(
        val id: String,
        val name: String,
        val image: String,
    ) : ChooserOption()

    data class CategoryOption(
        val id: String,
        val name: String,
        val icon: ImageVector,
    ) : ChooserOption()

    data class FrequencyOption(
        val id: String,
        val label: String,
    ) : ChooserOption()
}