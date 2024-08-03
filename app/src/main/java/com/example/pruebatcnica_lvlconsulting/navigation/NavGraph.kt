package com.example.pruebatcnica_lvlconsulting.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.pruebatcnica_lvlconsulting.View.ApiResponseView
import com.example.pruebatcnica_lvlconsulting.View.EditView
import com.example.pruebatcnica_lvlconsulting.View.SearchView
import com.example.pruebatcnica_lvlconsulting.View.HomeView
import com.example.pruebatcnica_lvlconsulting.View.LoginView
import com.example.pruebatcnica_lvlconsulting.View.NewProjectView
import com.example.pruebatcnica_lvlconsulting.View.PerfilView
import com.example.pruebatcnica_lvlconsulting.View.SplashView

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashView(navController) }
        composable("login") { LoginView(navController) }
        composable("home") { HomeView(navController) }
        composable("new_project") { NewProjectView(navController) }
        composable("search") {
            SearchView(onDismiss = { navController.popBackStack() })
        }
        composable("api") { ApiResponseView(navController) }
        composable("profile") { PerfilView(navController) }
        composable("edit") { EditView(navController) }
        }

    }


