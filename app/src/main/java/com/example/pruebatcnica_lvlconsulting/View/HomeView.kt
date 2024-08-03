package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import com.example.pruebatcnica_lvlconsulting.cards.TaskCard
import com.example.pruebatcnica_lvlconsulting.R
import com.example.pruebatcnica_lvlconsulting.ui.theme.AppColor
import com.example.pruebatcnica_lvlconsulting.ui.theme.fondoColor


@Composable
fun HomeView(navController: NavHostController) {
    var showSearchDialog by remember { mutableStateOf(false) }

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
                .padding(innerPadding)
                .background(fondoColor)
        ) { Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
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
                    Text(
                        text = "CEO LVL Consulting",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.size(32.dp),
                    tint = AppColor
                )
            }
        }

            ClickableButton()
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tableros",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "API",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = {
                        navController.navigate("api")

                    }) {
                        Icon(
                            imageVector = Icons.Default.Api,
                            contentDescription = "Más opciones",
                            tint = AppColor
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Cards
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    TaskCard(
                        title = "Proyecto de App",
                        status = "ATA-1",
                        state = "PLANIFICACIÓN",
                        iconRes = R.drawable.folder,
                        backgroundRes = R.drawable.fondo
                    )
                }
                item {
                    TaskCard(
                        title = "Diseño de RR.SS.",
                        status = "PA-21",
                        state = "EN CURSO",
                        iconRes = R.drawable.text,
                        backgroundRes = R.drawable.fondo
                    )
                }
                item {
                    TaskCard(
                        title = "Programación de...",
                        status = "PA-2",
                        state = "EN REVISIÓN",
                        iconRes = R.drawable.briefcase,
                        backgroundRes = R.drawable.fondo
                    )
                }
                item {
                    TaskCard(
                        title = "Control de calidad",
                        status = "ATA-1",
                        state = "FINALIZADO",
                        iconRes = R.drawable.adversiting,
                        backgroundRes = R.drawable.fondo
                    )
                }
                item {
                    TaskCard(
                        title = "Notificaciones de...",
                        status = "ATA-1",
                        state = "PLANIFICACIÓN",
                        iconRes = R.drawable.email,
                        backgroundRes = R.drawable.fondo
                    )
                }
                item {
                    TaskCard(
                        title = "Pago de ventanilla",
                        status = "PA-2",
                        state = "EN REVISIÓN",
                        iconRes = R.drawable.calendar,
                        backgroundRes = R.drawable.fondo
                    )
                }
            }
        }
    }

    if (showSearchDialog) {
        SearchView(onDismiss = { showSearchDialog = false })
    }
}


@Composable
fun ClickableButton() {
    var showSearchDialog by remember { mutableStateOf(false) }

    fun openSearchDialog() {
        showSearchDialog = true
    }

    Button(
        onClick = { openSearchDialog() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(48.dp)
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(20.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = AppColor,
                modifier = Modifier.padding(end = 8.dp) // Espacio entre el ícono y el texto
            )
            Text(
                text = "Buscar en tableros",
                color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f)) // Espacio flexible para alinear el ícono y el texto
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = "Filter Icon",
                tint = AppColor
            )
        }
    }

    if (showSearchDialog) {
        SearchView(onDismiss = { showSearchDialog = false })
    }
}