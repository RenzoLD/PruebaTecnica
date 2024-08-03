package com.example.pruebatcnica_lvlconsulting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pruebatcnica_lvlconsulting.navigation.NavGraph
import com.example.pruebatcnica_lvlconsulting.ui.theme.PruebaTécnicaLVLConsultingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTécnicaLVLConsultingTheme {
                //val navController = rememberNavController()
                NavGraph()

                //ApiResponseView()

                // Mostrar datos en Logcat
                /*LaunchedEffect(Unit) {
                    clientViewModel.clients.collect { clients ->
                        clients.forEach { client ->
                            Log.d("ClientInfo", "Client: ${client.name}, Email: ${client.email}")
                        }
                    }
                }*/


            }
        }
    }
}