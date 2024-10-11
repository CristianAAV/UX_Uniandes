package com.programador.programadortat.VerAlarmas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.programador.programadortat.Navigation.AppScreen
import com.programador.programadortat.*
import kotlin.random.Random


@Composable
fun VerAlarmas(navController: NavController)
{
    VerAlarma(navController)
}


@Composable
fun VerAlarma(navController: NavController)
{

    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFE8CAA4), Color(0xFF64908A))
                )
            )
            .padding(start = 27.dp, end = 27.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                modifier = Modifier.padding(top = 54.dp),
                text = "PROGRAMADOR TAT",
                fontFamily = poppinsAppStyle.fontFamily,
                fontSize = poppinsAppStyle.fontSize,
                fontWeight = poppinsAppStyle.fontWeight,
                color = poppinsAppStyle.color
            )
            Row (
                modifier = Modifier.padding(top = 16.dp),
            )
            {
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "!Tus Alarmas¡",
                    fontFamily = poppinsTitleStyle.fontFamily,
                    fontSize = poppinsTitleStyle.fontSize,
                    fontWeight = poppinsTitleStyle.fontWeight,
                    color = poppinsTitleStyle.color
                )
            }
            val nombres = listOf("Alarma 1", "Alarma 2", "Alarma 3", "Alarma 4", "Alarma 5", "Alarma 6", "Alarma 7", "Alarma 8")

            // Usar LazyColumn para permitir desplazamiento
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(nombres) { nombre ->
                    val activeDays = generateRandomActiveDays() // Días aleatorios
                    Alarm(
                        nombre = nombre,
                        onClick = { navController.navigate(AppScreen.DetalleAlarma.createRoute(nombre)) },
                        activeDays = activeDays,
                        enabled = true // O false si quieres deshabilitar el botón
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16dp
                }

            }
        }
    }
}

fun generateRandomActiveDays(): Set<String> {
    val allDays = listOf("L", "M", "MI", "J", "V", "S", "D")
    // Selecciona un número aleatorio de días (puede ser entre 1 y 7)
    val randomCount = Random.nextInt(1, allDays.size + 1)
    return allDays.shuffled().take(randomCount).toSet()
}


@Composable
fun Alarm(
    onClick: () -> Unit,
    nombre: String,
    activeDays: Set<String>, // Días activos
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val buttonColor = Color(0xFFE8CAA4)
    val hoverColor = buttonColor.copy(alpha = 1f).compositeOver(Color(0XFF351330).copy(alpha = 0.3f))
    val currentColor = if (isHovered) hoverColor else buttonColor

    // Colores
    val circleColor = Color(0xFFE8CAA4)
    val selectedColor = Color(0xFF95867C) // Color para el día seleccionado

    // Mapeo de letras a días
    val letters = listOf("L", "M", "MI", "J", "V", "S", "D")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .border(2.dp, Color(0xFF3E6963), RoundedCornerShape(12.dp))
            .clickable(onClick = onClick) // Hacer clic en todo el componente
    ) {
        // Sombra debajo del botón
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color(0Xff351330).copy(alpha = 0.3f))
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(12.dp))
                .offset(y = 2.dp)
        )

        // Fondo del botón
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(currentColor)
        ) {
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = nombre,
                            fontFamily = poppinsBottonStyle.fontFamily,
                            fontSize = poppinsBottonStyle.fontSize,
                            fontWeight = poppinsBottonStyle.fontWeight,
                            color = poppinsBottonStyle.color
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = "27/09/2024  16:40",
                            fontFamily = poppinsBottonStyle.fontFamily,
                            fontSize = poppinsBottonStyle.fontSize,
                            fontWeight = poppinsBottonStyle.fontWeight,
                            color = poppinsBottonStyle.color
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    letters.forEach { letter ->
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    if (activeDays.contains(letter)) selectedColor else circleColor,
                                    shape = CircleShape
                                )
                                .border(2.dp, Color(0xFF351330), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = letter,
                                fontFamily = poppinsBottonStyle.fontFamily,
                                fontSize = poppinsBottonStyle.fontSize,
                                fontWeight = poppinsBottonStyle.fontWeight,
                                color = poppinsBottonStyle.color
                            )
                        }
                    }
                }
            }

            if (isHovered) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .matchParentSize()
                        .background(Color(0xff351330).copy(alpha = 0.3f))
                        .clip(RoundedCornerShape(12.dp))
                )
            }
        }
    }
}

