package com.example.pruebatcnica_lvlconsulting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebatcnica_lvlconsulting.Navigation.NavGraph
import com.example.pruebatcnica_lvlconsulting.View.FragmentView
import com.example.pruebatcnica_lvlconsulting.View.HomeView
import com.example.pruebatcnica_lvlconsulting.View.LoginView
import com.example.pruebatcnica_lvlconsulting.View.NewProjectView
import com.example.pruebatcnica_lvlconsulting.View.PerfilView
import com.example.pruebatcnica_lvlconsulting.View.SplashScreen
import com.example.pruebatcnica_lvlconsulting.ui.theme.PruebaTécnicaLVLConsultingTheme
import kotlinx.coroutines.delay

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
