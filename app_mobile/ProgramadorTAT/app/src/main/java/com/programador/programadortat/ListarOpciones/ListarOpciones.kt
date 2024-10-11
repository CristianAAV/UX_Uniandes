package com.programador.programadortat.ListarOpciones

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.programador.programadortat.Navigation.AppScreen
import com.programador.programadortat.R
import com.programador.programadortat.*


@Composable
fun ListarOpciones(navController: NavController)
{
    Options(navController)
}



@Composable
fun Options(navController: NavController) {
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
            Row(
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(), // Asegúrate de que la fila ocupe todo el ancho
                verticalAlignment = Alignment.CenterVertically // Alinear verticalmente al centro
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                        .padding(start = 60.dp), // Esto permite que el texto ocupe el espacio disponible
                    contentAlignment = Alignment.Center // Centra el texto dentro del Box
                ) {
                    Text(
                        text = "!Hola¡, Usuario",
                        fontFamily = poppinsTitleStyle.fontFamily,
                        fontSize = poppinsTitleStyle.fontSize,
                        fontWeight = poppinsTitleStyle.fontWeight,
                        color = poppinsTitleStyle.color
                    )
                }
                Box(
                    modifier = Modifier.size(40.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }


            newButton(onClick = { navController.navigate(AppScreen.CrearAlarma.route) }, nombre = "CREAR ALARMA", imagen = R.drawable.editar)
            newButton(onClick = { navController.navigate(AppScreen.VerAlarmas.route) }, nombre = "VER ALARMAS", imagen = R.drawable.ver)
            newButton(onClick = { navController.navigate(AppScreen.GenerarIA.route) }, nombre = "GENERAR CON IA", imagen = R.drawable.ia)
            newButton(onClick = { navController.navigate(AppScreen.Configurar.route) }, nombre = "CONFIGURAR ENVIO", imagen = R.drawable.config)
            newButton(onClick = { /*TODO*/}, nombre = "GESTIONAR PERFIL", imagen = R.drawable.perfil,enabled = false)

        }
    }
}


@Composable
fun newButton(onClick: () -> Unit, nombre: String, imagen: Int, enabled: Boolean = true) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val buttonColor = Color(0xFF64908A)
    val hoverColor = buttonColor.copy(alpha = 1f).compositeOver(Color.Black.copy(alpha = 0.3f))
    val currentColor = if (isHovered) hoverColor else buttonColor

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .border(2.dp, Color(0xFF3E6963), RoundedCornerShape(12.dp))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 9.dp, end =5.dp)
                .height(4.dp)
                .width(200.dp)
                .offset(y = 4.dp)
                .background(Color(0XFF424254).copy(alpha = 0.5f))
                .clip(RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp))
                .align(Alignment.BottomCenter)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(currentColor)
                .padding(bottom = 4.dp)
        ) {
            Button(
                enabled = enabled,
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent // Hacer el botón transparente
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                interactionSource = interactionSource
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = imagen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 3.dp)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = nombre,
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
                    .matchParentSize() // Cubre todo el botón
                    .background(Color.Black.copy(alpha = 0.3f)) // Oscurecimiento
                    .clip(RoundedCornerShape(12.dp)) // Mantener esquinas redondeadas
            )
        }
    }
}
