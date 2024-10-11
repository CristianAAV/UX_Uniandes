package com.programador.programadortat.Navigation


sealed class AppScreen (val route: String)
{   //Crear Rutas
    object ListarOpciones:AppScreen("ListarOpciones")
    object CrearAlarma:AppScreen("CrearAlarma")
    object GenerarIA:AppScreen("GenerarIA")
    object Configurar:AppScreen("Configurar")
    object VerAlarmas:AppScreen("VerAlarmas")
    object DetalleAlarma : AppScreen("DetalleAlarma/{nombre}") {
        fun createRoute(nombre: String) = "DetalleAlarma/$nombre"}
}