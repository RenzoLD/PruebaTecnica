package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pruebatcnica_lvlconsulting.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewProjectView(navController: NavHostController) {
    var nombreProyecto by remember { mutableStateOf(TextFieldValue("")) }
    var descripcion by remember { mutableStateOf(TextFieldValue("")) }
    var estadoProyecto by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("") }
    var fechaFinalizacion by remember { mutableStateOf("") }
    var compartirConOtros by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nuevo proyecto") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable { /* Cambiar icono */ },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.screen),
                    contentDescription = "Icono del proyecto"
                )
            }
            TextButton(onClick = { /* Cambiar icono aleatorio */ }) {
                Text(text = "Cambiar icono aleatorio")
            }
            OutlinedTextField(
                value = nombreProyecto,
                onValueChange = { nombreProyecto = it },
                label = { Text(text = "Nombre del proyecto") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text(text = "Descripción") },
                modifier = Modifier.fillMaxWidth()
            )
            DropdownMenuDemo(
                selectedOption = estadoProyecto,
                onOptionSelected = { estadoProyecto = it })
            OutlinedTextField(
                value = fechaInicio,
                onValueChange = { fechaInicio = it },
                label = { Text(text = "Fecha de inicio") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = fechaFinalizacion,
                onValueChange = { fechaFinalizacion = it },
                label = { Text(text = "Fecha de finalización") },
                modifier = Modifier.fillMaxWidth()
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "¿Compartir con otros miembros?")
                Switch(
                    checked = compartirConOtros,
                    onCheckedChange = { compartirConOtros = it }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Crear proyecto */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Crear proyecto")
            }
        }
    }
}


@Composable
fun DropdownMenuDemo(selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Opción 1", "Opción 2", "Opción 3")

    Box {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            label = { Text(text = "Estado del proyecto") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
        }
    }
}
