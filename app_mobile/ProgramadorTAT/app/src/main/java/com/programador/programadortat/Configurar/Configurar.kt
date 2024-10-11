package com.programador.programadortat.GenerarIA


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.programador.programadortat.*
import com.programador.programadortat.CrearAlarma.AceptarCancelar
import com.programador.programadortat.Navigation.AppScreen

@Composable
fun Configurar(navController: NavController) {
    val onAceptarClick = { navController.navigate(AppScreen.ListarOpciones.route) }
    val onCancelarClick = { navController.navigate(AppScreen.ListarOpciones.route) }
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
                /*fontFamily = poppinsAppStyle.fontFamily,*/
                fontSize = poppinsAppStyle.fontSize,
                fontWeight = poppinsAppStyle.fontWeight,
                color = poppinsAppStyle.color
            )
            Row {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "CREAR ALARMA",
                    fontFamily = poppinsTitleStyle.fontFamily,
                    fontSize = poppinsTitleStyle.fontSize,
                    fontWeight = poppinsTitleStyle.fontWeight,
                    color = poppinsTitleStyle.color
                )
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
            LabeledCheckboxText(
                label = "Url de la Empresa"
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            LabeledCheckboxText(
                label = "Email"
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            LabeledCheckboxText(
                label = "Whatsapp"
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))

            AceptarCancelar(
                onAceptarClick = onAceptarClick,
                onCancelarClick = onCancelarClick,
                nombreAceptar = "Aceptar",
                nombreCancelar = "Cancelar"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun LabeledCheckboxText(label: String) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val isChecked = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    // Fila para el label y el checkbox
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        // Texto de etiqueta
        Text(
            text = label,
            modifier = Modifier.weight(1f), // Ocupa el espacio restante
            textAlign = TextAlign.Start,
            fontFamily = poppinsLabelStyle.fontFamily,
            fontSize = poppinsLabelStyle.fontSize,
            fontWeight = poppinsLabelStyle.fontWeight,
            color = poppinsLabelStyle.color
        )

        // Checkbox
        Box(
            modifier = Modifier
                .size(30.dp) // Tamaño del contenedor del checkbox
                .clip(RoundedCornerShape(8.dp)) // Esquinas redondeadas
                .border(2.dp, Color(0xFF351330), RoundedCornerShape(8.dp)) // Bordes redondeados
                .background(if (isChecked.value) Color(0xFF424254).copy(alpha = 0.5f) else Color.Transparent)
                .clickable {
                    isChecked.value = !isChecked.value
                    if (!isChecked.value) {
                        textState.value = TextFieldValue("") // Limpia el campo de texto si se desmarca
                    }
                } // Cambia el estado al hacer clic
        ) {
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                    if (!it) {
                        textState.value = TextFieldValue("") // Limpia el campo de texto si se desmarca
                    }
                }, // Actualiza el estado al cambiar el checkbox
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Transparent, // Color cuando está marcado
                    uncheckedColor = Color.Transparent, // Color cuando no está marcado
                    checkmarkColor = Color(0xFF351330) // Color del checkmark
                ),
                modifier = Modifier
                    .size(14.dp) // Tamaño del checkbox
                    .align(Alignment.Center) // Centra el checkbox dentro del Box
            )
        }
    }

    // Contenedor del TextField
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .border(
                BorderStroke(2.dp, Color(0XFF351330)), // Grosor y color del borde
                shape = RoundedCornerShape(12.dp) // Esquinas redondeadas
            )
            .background(
                if (isChecked.value) Color.Transparent else Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        TextField(
            value = textState.value,
            onValueChange = { if (isChecked.value) textState.value = it }, // Solo actualiza si está marcado
            enabled = isChecked.value, // Habilita o deshabilita el TextField
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color(0XFF351330),
                unfocusedTextColor = Color(0XFF351330),
                disabledTextColor = Color(0XFF351330)
            ),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontFamily = poppinsBottonStyle.fontFamily,
                fontSize = poppinsBottonStyle.fontSize,
                fontWeight = poppinsBottonStyle.fontWeight,
                color = poppinsBottonStyle.color,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "",
                    fontFamily = poppinsBottonStyle.fontFamily,
                    fontSize = poppinsBottonStyle.fontSize,
                    fontWeight = poppinsBottonStyle.fontWeight,
                    color = poppinsBottonStyle.color,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // Establece la acción del teclado en "Done"
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
    }
}
