package com.example.pruebatcnica_lvlconsulting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebatcnica_lvlconsulting.Navigation.NavGraph
import com.example.pruebatcnica_lvlconsulting.ui.theme.PruebaTécnicaLVLConsultingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTécnicaLVLConsultingTheme {
                val navController = rememberNavController()
                NavGraph()

                }

            }
        }
    }
