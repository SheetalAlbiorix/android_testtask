package com.jetpack.paymentflowtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jetpack.paymentflowtest.ui.theme.PaymentFlowTestTheme
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaymentFlowTestTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AppRoute.Home,
                ) {
                    composable<AppRoute.Home> {
//                        val serviceChooser = remember { ChooserData.ServiceData }
//                        val categoryChooser = remember { ChooserData.CategoryData }
//                        val dateChooser = remember { ChooserData.DateData }
//                        val frequencyChooser = remember { ChooserData.FrequencyData }
                        CreateSubscription({}, {})
                    }

                    dialog<AppRoute.ItemChooser> { backStackEntry ->
                        val chooser = backStackEntry.toRoute<AppRoute.ItemChooser>()
                        val data: ChooserData<Any> = Json.decodeFromString(chooser.chooserData)
                        ModalBottomSheet(onDismissRequest = { navController.popBackStack() }) {
                            when (data) {
                                is ChooserData.ServiceData -> Text(data.type.name)
                                is ChooserData.CategoryData -> Text(data.type.name)
                                is ChooserData.DateData -> Text(data.type.name)
                                is ChooserData.FrequencyData -> Text(data.type.name)
                            }
//                            when (type) {
//                                ChooserType.SERVICE -> showServiceChooser(chooserData.options.filterIsInstance<ChooserOption.ServiceOption>())
//                                ChooserType.CATEGORY -> showCategoryChooser()
//                                ChooserType.DATE -> showDateChooser()
//                                ChooserType.FREQUENCY -> showFrequencyChooser()
//                            }
                        }
                    }
                }
            }
        }
    }
}