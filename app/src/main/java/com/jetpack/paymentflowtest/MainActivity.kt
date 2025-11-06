package com.jetpack.paymentflowtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpack.paymentflowtest.pages.CreateSubscriptionPage
import com.jetpack.paymentflowtest.pages.HomePage
import com.jetpack.paymentflowtest.ui.theme.PaymentFlowTestTheme

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
                        HomePage(
                            onCreateSubscriptionClick = {
                                navController.navigate(AppRoute.CreateSubscription)
                            }
                        )
                    }
                    composable<AppRoute.CreateSubscription> {
                        CreateSubscriptionPage(
                            onClose = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}