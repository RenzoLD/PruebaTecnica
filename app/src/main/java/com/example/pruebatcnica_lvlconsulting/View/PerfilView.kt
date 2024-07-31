package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun PerfilView(navController: NavHostController) {
    Box {
        Text(
            text = "Perfil",
            modifier = Modifier
                .clickable {
                    navController.navigate("perfil")
                })

    }
}