package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.text.font.FontWeight
import com.example.pruebatcnica_lvlconsulting.R
import com.example.pruebatcnica_lvlconsulting.ui.theme.AppColor


@Composable
fun HomeView(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("new_project")
                },
                containerColor = AppColor,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding) // Añade el padding proporcionado por Scaffold
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Espacia los elementos entre sí
            ) {
                // Imagen de perfil y detalles
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                navController.navigate("profile")
                            }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Miguel Liberato",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "CEO LVL Consulting", fontSize = 14.sp, color = Color.Gray)
                    }
                }

                // Icono de campana
                IconButton(onClick = { /* Acción de notificación */ }) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = AppColor
                    )
                }
            }

            // Search Bar
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Buscar en tableros") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = AppColor
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        navController.navigate("search")
                    }) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filter Icon",
                            tint = AppColor
                        )
                    }
                },
                shape = RoundedCornerShape(20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = "Tableros",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    TaskCard(
                        title = "Proyecto de App",
                        status = "ATA-1",
                        icon = Icons.Default.Folder
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TaskCard(
                        title = "Notificaciones ATA-1",
                        status = "PLANIFICACIÓN",
                        icon = Icons.Default.Notifications
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    TaskCard(
                        title = "Control de calidad",
                        status = "EN CURSO",
                        icon = Icons.Default.Warning
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TaskCard(
                        title = "Pago de ventanilla PA-2",
                        status = "FINALIZADO",
                        icon = Icons.Default.CheckCircle
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCard(title: String, status: String, icon: ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = status, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}
