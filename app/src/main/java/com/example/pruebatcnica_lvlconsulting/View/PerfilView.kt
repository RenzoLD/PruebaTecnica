package com.example.pruebatcnica_lvlconsulting.View


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebatcnica_lvlconsulting.R
import com.example.pruebatcnica_lvlconsulting.ui.theme.AppColor

@Composable
fun PerfilView(navController: NavHostController) {
    var nombres by remember { mutableStateOf("Miguel Ángel") }
    var apellidos by remember { mutableStateOf("Liberato Carmín") }
    var cargo by remember { mutableStateOf("CEO LVL Consulting") }
    var telefono by remember { mutableStateOf("+51 987654321") }
    var correo by remember { mutableStateOf("miguelliberato@gmail.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Añade padding en la parte inferior
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = AppColor
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Mi perfil",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .clickable { /* Cambiar imagen */ },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape) // Opcional: Si quieres la imagen en forma de círculo
            )

            // Icono de editar
            Icon(
                painter = painterResource(id = R.drawable.screen),
                contentDescription = "Cambiar imagen",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.BottomEnd) // Alinea el ícono en la parte inferior derecha
                    .padding(8.dp) // Añade padding para que no quede pegado al borde
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Campos de perfil
        ProfileTextField(label = "Nombres", value = nombres, onValueChange = { nombres = it })
        ProfileTextField(label = "Apellidos", value = apellidos, onValueChange = { apellidos = it })
        ProfileTextField(label = "Cargo en la empresa", value = cargo, onValueChange = { cargo = it })
        ProfileTextField(label = "Teléfono", value = telefono, onValueChange = { telefono = it })
        ProfileTextField(label = "Correo electrónico", value = correo, onValueChange = { correo = it })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Guardar cambios */ }) {
            Text(text = "Guardar")
        }
    }
}

@Composable
fun ProfileTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}
