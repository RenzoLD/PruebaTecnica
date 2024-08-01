package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.example.pruebatcnica_lvlconsulting.R
import com.example.pruebatcnica_lvlconsulting.ui.theme.AppColor
import com.example.pruebatcnica_lvlconsulting.ui.theme.fondoColor


@OptIn(ExperimentalComposeUiApi::class)
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
        ) {
            // Header
            Row(
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
                        Text(text = "CEO LVL Consulting", fontSize = 14.sp, color = Color.Gray)
                    }
                }

                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.notis),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            @Composable
            fun NonClickableOutlinedTextField() {
                var text by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    label = { Text("Buscar en tableros") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    readOnly = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = AppColor
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.FilterList,
                                contentDescription = "Filter Icon",
                                tint = AppColor
                            )
                        }
                    },
                    shape = RoundedCornerShape(20.dp)
                )
            }
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
fun TaskCard(title: String, status: String, state: String, iconRes: Int, backgroundRes: Int) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp), // Sin elevación para el fondo
        colors = CardDefaults.cardColors(containerColor = Color.Transparent) // Fondo transparente
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
        ) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = backgroundRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize() // Asegúrate de que la imagen llene todo el Box
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterStart) // Alinea la columna en el centro de la caja
            ) {
                // Imagen en la parte superior en un círculo
                Image(
                    painter = rememberAsyncImagePainter(model = iconRes),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la imagen y el título
                // Texto de la tarjeta
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 4.dp) // Espacio debajo del título
                    )
                    Text(
                        text = status,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 4.dp) // Espacio debajo del status
                    )
                    Text(
                        text = state,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = when (state) {
                            "PLANIFICACIÓN" -> Color.Gray
                            "EN CURSO" -> Color.Yellow
                            "EN REVISIÓN" -> Color.Green
                            "FINALIZADO" -> Color.Blue
                            else -> Color.Gray
                        },
                        textAlign = TextAlign.Start // Cambiado a Start para alineación coherente
                    )
                }
            }
        }
    }
}
