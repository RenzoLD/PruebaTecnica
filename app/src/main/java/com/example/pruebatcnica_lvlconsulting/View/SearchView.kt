package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun SearchView(navController: NavHostController) {
    var projectCode by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var state by remember { mutableStateOf(TextFieldValue("")) }
    var category by remember { mutableStateOf(TextFieldValue("")) }
    var icon by remember { mutableStateOf(TextFieldValue("")) }
    var startDate by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Búsqueda avanzada", style = MaterialTheme.typography.titleMedium)
        BasicTextField(
            value = projectCode,
            onValueChange = { projectCode = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (projectCode.text.isEmpty()) {
                        Text("Código del proyecto")
                    }
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (name.text.isEmpty()) {
                        Text("Nombre")
                    }
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = state,
            onValueChange = { state = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (state.text.isEmpty()) {
                        Text("Estado")
                    }
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = category,
            onValueChange = { category = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (category.text.isEmpty()) {
                        Text("Categoría del Proyecto")
                    }
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = icon,
            onValueChange = { icon = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (icon.text.isEmpty()) {
                        Text("Icono de miyué")
                    }
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = startDate,
            onValueChange = { startDate = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    if (startDate.text.isEmpty()) {
                        Text("Fecha de inicio")
                    }
                    innerTextField()
                }
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* Buscar acción */ }) {
                Text("Buscar")
            }
            Button(onClick = { /* Limpiar acción */ }) {
                Text("Limpiar")
            }
        }
    }
}