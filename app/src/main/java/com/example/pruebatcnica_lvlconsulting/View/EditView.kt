package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import com.example.pruebatcnica_lvlconsulting.R
import com.example.pruebatcnica_lvlconsulting.ui.theme.fondoColor

@Composable
fun EditView(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(48.dp)) // Espacio superior

            // Imagen circular
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            )

            // Espaciador para centrar la imagen y los botones
            Spacer(modifier = Modifier.height(24.dp))

            // Botones de acciones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton(
                    icon = Icons.Default.Edit,
                    text = "Editar",
                    onClick = { /* Acción de editar */ })
                ActionButton(
                    icon = Icons.Default.PhotoCamera,
                    text = "Hacer foto",
                    onClick = { /* Acción de hacer foto */ })
                ActionButton(
                    icon = Icons.Default.PhotoLibrary,
                    text = "Galería",
                    onClick = { /* Acción de galería */ })
                ActionButton(
                    icon = Icons.Default.Delete,
                    text = "Eliminar",
                    onClick = { /* Acción de eliminar */ })
            }
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick) {
            Icon(imageVector = icon, contentDescription = text, tint = Color.White)
        }
        Text(text = text, color = Color.White, fontSize = 12.sp)
    }
}