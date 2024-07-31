package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewProjectView(navController: NavHostController) {
    var projectName by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var startDateEnabled by remember { mutableStateOf(false) }
    var endDateEnabled by remember { mutableStateOf(false) }
    var shareWithMembers by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Nuevo proyecto", fontSize = 24.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Nombre del proyecto")
        BasicTextField(
            value = projectName,
            onValueChange = { projectName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Descripción")
        BasicTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Fecha de inicio")
            Switch(
                checked = startDateEnabled,
                onCheckedChange = { startDateEnabled = it }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Fecha de finalización")
            Switch(
                checked = endDateEnabled,
                onCheckedChange = { endDateEnabled = it }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("¿Compartir con otros miembros?")
            Switch(
                checked = shareWithMembers,
                onCheckedChange = { shareWithMembers = it }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /* Acción para crear el proyecto */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Crear proyecto")
        }
    }
}