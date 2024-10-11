package com.programador.programadortat.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.programador.programadortat.ListarOpciones.ListarOpciones
import com.programador.programadortat.CrearAlarma.CrearAlarma
import com.programador.programadortat.DetalleAlarma.DetalleAlarma
import com.programador.programadortat.GenerarIA.GenerarIA
import com.programador.programadortat.GenerarIA.Configurar
import com.programador.programadortat.VerAlarmas.VerAlarmas

@Composable
fun NavigationScreens()
{
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = AppScreen.ListarOpciones.route)
    {
        composable(route = AppScreen.ListarOpciones.route)
        {
            ListarOpciones(navController)
        }
        composable(route = AppScreen.CrearAlarma.route)
        {
            CrearAlarma(navController)
        }
        composable(route = AppScreen.GenerarIA.route)
        {
            GenerarIA(navController)
        }
        composable(route = AppScreen.Configurar.route)
        {
            Configurar(navController)
        }
        composable(route= AppScreen.VerAlarmas.route)
        {
            VerAlarmas(navController)
        }
        composable(
            route = AppScreen.DetalleAlarma.route,
            arguments = listOf(navArgument("nombre") { type = NavType.StringType })
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            DetalleAlarma(nombre = nombre)
        }
    }
}