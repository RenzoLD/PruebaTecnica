package com.example.pruebatcnica_lvlconsulting.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pruebatcnica_lvlconsulting.cards.ApiCard
import com.example.pruebatcnica_lvlconsulting.data.model.Place
import com.example.pruebatcnica_lvlconsulting.presentation.PlaceListViewModel
import com.example.pruebatcnica_lvlconsulting.ui.theme.AppColor
import com.example.pruebatcnica_lvlconsulting.ui.theme.fondoColor
import com.example.pruebatcnica_lvlconsulting.util.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApiResponseView(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: PlaceListViewModel = hiltViewModel()
    val result by viewModel.places.observeAsState(Result.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Back", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = AppColor)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = fondoColor)
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(fondoColor)
            ) {
                when (result) {
                    is Result.Success -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = modifier.fillMaxSize()
                        ) {
                            items((result as Result.Success<List<Place>>).data) { place ->
                                ApiCard(place = place, modifier = Modifier.fillMaxWidth())
                            }
                        }
                    }

                    is Result.Error -> {
                        Text(
                            text = (result as Result.Error).exception.message
                                ?: "An unknown error occurred",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    is Result.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    else -> {}
                }
            }
        }
    )
}
