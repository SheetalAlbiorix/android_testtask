package com.jetpack.paymentflowtest

import kotlinx.serialization.Serializable

sealed interface AppRoute {

    @Serializable
    data object Home : AppRoute

    @Serializable
    data class ItemChooser(val chooserData: String = "") : AppRoute
}