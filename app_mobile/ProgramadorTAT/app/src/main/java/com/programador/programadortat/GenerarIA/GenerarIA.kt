package com.programador.programadortat.GenerarIA


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.programador.programadortat.*
import com.programador.programadortat.CrearAlarma.AceptarCancelar
import com.programador.programadortat.Navigation.AppScreen
import kotlin.random.Random

@Composable
fun GenerarIA(navController: NavController) {
    val randomNumber = Random.nextInt(1, 9)
    val randomDay = Random.nextInt(1, 32)
    val randomMonth = Random.nextInt(1, 13)
    val randomYear = Random.nextInt(2024, 2025)
    val randomDate = "$randomDay/$randomMonth/$randomYear"
    val randomHour = Random.nextInt(1, 25)
    val randomMinute = Random.nextInt(1, 60)
    val randomHours = "$randomHour:$randomMinute"
    val onAceptarClick = { navController.navigate(AppScreen.VerAlarmas.route) }
    val onCancelarClick = { navController.navigate(AppScreen.ListarOpciones.route) }
    val initialCheckedState = Random.nextBoolean() // Genera un booleano aleatorio

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
        Text(
            modifier = Modifier.padding(top = 54.dp),
            text = "PROGRAMADOR TAT",
            fontFamily = poppinsAppStyle.fontFamily,
            fontSize = poppinsAppStyle.fontSize,
            fontWeight = poppinsAppStyle.fontWeight,
            color = poppinsAppStyle.color
        )


        // LazyColumn para organizar los elementos
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado entre los elementos
            contentPadding = PaddingValues(top = 16.dp) // Espaciado en la parte superior
        ) {
            item{
                Row {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "Alarma Generada por IA",
                        fontFamily = poppinsTitleStyle.fontFamily,
                        fontSize = poppinsTitleStyle.fontSize,
                        fontWeight = poppinsTitleStyle.fontWeight,
                        color = poppinsTitleStyle.color
                    )
                }

            }
            item {
                LabelAndTextFieldIA(label = "Nombre de la alarma", alarmNumber = randomNumber)
            }
            item {
                DateInputFieldIA(date = randomDate)
            }
            item {
                TimeInputFieldIA(hours = randomHours)
            }
            item {
                FrecuenceIA("Frecuencia")
            }
            item {
                LabeledCheckboxIA(checked = initialCheckedState,
                label = "Ubicación",
                imagePainter = painterResource(id = R.drawable.mapa) // Carga una imagen local desde recursos
                )
            }
            item {
                InformeTextFieldIA(label = "Informe")
            }
            item {
                AceptarCancelar(
                    onAceptarClick = onAceptarClick,
                    onCancelarClick = onCancelarClick,
                    nombreAceptar = "Aceptar",
                    nombreCancelar = "Cancelar"
                )

            }
            item { Spacer(modifier = Modifier.height(0.dp)) }
        }
    }
}


@Composable
fun LabelAndTextFieldIA(label: String, alarmNumber: Int) {
    val textState = remember { mutableStateOf(TextFieldValue("Alarma $alarmNumber")) } // Texto por defecto
    val focusManager = LocalFocusManager.current

    Text(
        text = label,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start,
        fontFamily = poppinsLabelStyle.fontFamily,
        fontSize = poppinsLabelStyle.fontSize,
        fontWeight = poppinsLabelStyle.fontWeight,
        color = poppinsLabelStyle.color
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .border(
                BorderStroke(2.dp, Color(0XFF351330)),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = textState.value,
            colors = TextFieldDefaults.colors(
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
            onValueChange = { newText -> textState.value = newText },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Box(
                    modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "",
                        fontFamily = poppinsBottonStyle.fontFamily,
                        fontSize = poppinsBottonStyle.fontSize,
                        fontWeight = poppinsBottonStyle.fontWeight,
                        color = poppinsBottonStyle.color,
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
    }
}


@Composable
fun InformeTextFieldIA(label: String) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val randomVentas = Random.nextInt(1, 4)

    Text(
        text = label,
        modifier = Modifier.fillMaxWidth(), // Asegúrate de que el texto ocupe el ancho disponible
        textAlign = TextAlign.Start, // Alinea el texto a la izquierda
        fontFamily = poppinsLabelStyle.fontFamily,
        fontSize = poppinsLabelStyle.fontSize,
        fontWeight = poppinsLabelStyle.fontWeight,
        color = poppinsLabelStyle.color
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=8.dp)
            .border(
                BorderStroke(2.dp, Color(0XFF351330)), // Grosor y color del borde
                shape = RoundedCornerShape(12.dp) // Esquinas redondeadas
            )
            .background(
                Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        TextField(
            value = textState.value,
            colors = TextFieldDefaults.colors(
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
            onValueChange = { newText -> textState.value = newText },
            modifier = Modifier
                .fillMaxWidth(), // Asegúrate de que el TextField no cambie de altura (puedes ajustar el valor)
            placeholder = {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.Transparent), // Hace que el Box ocupe todo el ancho
                    contentAlignment = Alignment.Center // Centra el contenido dentro del Box
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Venta de Aplicaciones web  x$randomVentas",
                        fontFamily = poppinsBottonStyle.fontFamily,
                        fontSize = poppinsBottonStyle.fontSize,
                        fontWeight = poppinsBottonStyle.fontWeight,
                        color = poppinsBottonStyle.color,
                    )
                }
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

@Composable
fun DateInputFieldIA(date : String) {
    var dateState by remember { mutableStateOf(date) }
    var isDatePickerOpen by remember { mutableStateOf(false) }

    Text(
        text = "Fecha",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start,
        fontFamily = poppinsLabelStyle.fontFamily,
        fontSize = poppinsLabelStyle.fontSize,
        fontWeight = poppinsLabelStyle.fontWeight,
        color = poppinsLabelStyle.color,
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
            .defaultMinSize(minHeight = 60.dp) // Ajusta según tus necesidades
            .border(
                BorderStroke(2.dp, Color(0XFF351330)),
                shape = RoundedCornerShape(12.dp)
            )
            .background(Color.Transparent, shape = RoundedCornerShape(12.dp))
            .clickable { isDatePickerOpen = true }, // Abre el DatePicker al hacer clic
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente el contenido
            modifier = Modifier.fillMaxWidth().padding(8.dp) // Ajuste de padding
        ) {
            Text(
                text = dateState,
                textAlign = TextAlign.Center,
                fontFamily = poppinsBottonStyle.fontFamily,
                fontSize = poppinsBottonStyle.fontSize,
                fontWeight = poppinsBottonStyle.fontWeight,
                color = poppinsBottonStyle.color,
                modifier = Modifier.weight(1f) // Esto asegura que el texto ocupe el espacio disponible
            )
            Icon(
                painter = painterResource(id = R.drawable.date), // Reemplaza con tu recurso de imagen
                contentDescription = "Seleccionar fecha",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { isDatePickerOpen = true } // Abre el DatePicker al hacer clic en la imagen
            )
        }
    }

    // Lógica del DatePicker
    if (isDatePickerOpen) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            LocalContext.current,
            { _, selectedYear, selectedMonth, selectedDay ->
                dateState = "$selectedDay/${selectedMonth + 1}/$selectedYear" // Cambia el formato de la fecha
                isDatePickerOpen = false
            },
            year,
            month,
            day
        ).apply {
            setOnDismissListener { isDatePickerOpen = false }
        }.show()
    }
}





@Composable
fun TimeInputFieldIA(hours : String) {
    var timeState by remember { mutableStateOf(TextFieldValue("")) }
    var isTimePickerOpen by remember { mutableStateOf(false) }

    Text(
        text = "Hora",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start,
        fontFamily = poppinsLabelStyle.fontFamily,
        fontSize = poppinsLabelStyle.fontSize,
        fontWeight = poppinsLabelStyle.fontWeight,
        color = poppinsLabelStyle.color
    )

    Box(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 60.dp)
            .border(
                BorderStroke(2.dp, Color(0XFF351330)),
                shape = RoundedCornerShape(12.dp)
            )
            .background(Color.Transparent, shape = RoundedCornerShape(12.dp))
            .clickable { isTimePickerOpen = true }, // Abre el TimePicker
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente el contenido
            modifier = Modifier.fillMaxWidth().padding(8.dp) // Ajuste de padding
        ) {
            Text(
                text = timeState.text.ifEmpty { hours }, // Muestra el texto o placeholder
                textAlign = TextAlign.Center,
                fontFamily = poppinsBottonStyle.fontFamily,
                fontSize = poppinsBottonStyle.fontSize,
                fontWeight = poppinsBottonStyle.fontWeight,
                color = poppinsBottonStyle.color,
                modifier = Modifier.weight(1f) // Asegura que el texto ocupe el espacio disponible
            )
            Icon(
                painter = painterResource(id = R.drawable.hora), // Reemplaza con tu recurso de imagen
                contentDescription = "Seleccionar hora",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { isTimePickerOpen = true } // Abre el TimePicker al hacer clic en la imagen
            )
        }
    }

    // Lógica del TimePicker
    if (isTimePickerOpen) {
        // Obtener la hora actual
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        TimePickerDialog(
            LocalContext.current,
            { _, selectedHour, selectedMinute ->
                timeState = TextFieldValue(String.format("%02d:%02d", selectedHour, selectedMinute))
                isTimePickerOpen = false
            },
            hour,
            minute,
            true // Formato de 24 horas
        ).apply {
            setOnDismissListener { isTimePickerOpen = false } // Cierra el TimePicker al hacer clic fuera
        }.show()
    }
}

@Composable
fun FrecuenceIA(label: String) {
    // Lista de estados, uno por cada botón
    val pressedStates = remember { mutableStateOf(List(7) { false }) } // 7 para L, M, MI, J, V, S, D

    // Colores
    val circleColor = Color(0xFFE8CAA4)
    val overlayColor = Color(0xFF351330).copy(alpha = 0.3f)

    Text(
        text = label,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start,
        fontFamily = poppinsLabelStyle.fontFamily,
        fontSize = poppinsLabelStyle.fontSize,
        fontWeight = poppinsLabelStyle.fontWeight,
        color = poppinsLabelStyle.color
    )
    Spacer(modifier = Modifier.padding(top = 8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly // Espaciado uniforme
    ) {
        // Letras iniciales
        val letters = listOf("L", "M", "MI", "J", "V", "S", "D")

        letters.forEachIndexed { index, letter ->
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        if (pressedStates.value[index]) overlayColor else circleColor,
                        shape = CircleShape
                    )
                    .border(2.dp, Color(0xFF351330), CircleShape) // Borde del círculo
                    .clickable {
                        // Cambia el estado del botón correspondiente
                        pressedStates.value = pressedStates.value.mapIndexed { i, pressed ->
                            if (i == index) !pressed else pressed
                        }
                    },
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

    // Generar automáticamente días seleccionados al cargar la función
    LaunchedEffect(Unit) {
        val randomDays = (0..6).shuffled().take(Random.nextInt(1, 8)) // Genera entre 1 y 7 días aleatorios
        pressedStates.value = List(7) { randomDays.contains(it) }
    }
}




@Composable
fun LabeledCheckboxIA(
    checked: Boolean = false, // Estado inicial
    label: String,
    imagePainter: Painter // Pintor de la imagen
) {
    // Estado para controlar el estado del checkbox
    val isChecked = remember { mutableStateOf(checked) }

    Column(modifier = Modifier.fillMaxWidth()) {
        // Fila para el checkbox y su label
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween // Espaciado para alinear a la izquierda y derecha
        ) {
            Text(
                text = label,
                fontFamily = poppinsLabelStyle.fontFamily,
                fontSize = poppinsLabelStyle.fontSize,
                fontWeight = poppinsLabelStyle.fontWeight,
                color = poppinsLabelStyle.color
            )

            Box(
                modifier = Modifier
                    .size(30.dp) // Tamaño del contenedor del checkbox
                    .clip(RoundedCornerShape(8.dp)) // Esquinas redondeadas
                    .border(2.dp, Color(0xFF351330), RoundedCornerShape(8.dp)) // Bordes redondeados
                    .background(if (isChecked.value) Color(0xFF424254).copy(alpha = 0.5f) else Color.Transparent)
                    .clickable { isChecked.value = !isChecked.value } // Cambia el estado al hacer clic
            ) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it }, // Actualiza el estado al cambiar el checkbox
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

        // Contenedor para la imagen, que solo se muestra si el checkbox está marcado
        if (isChecked.value) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween // Espaciado para alinear a la izquierda y derecha
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp) // Establece una altura fija para la imagen
                        .padding(16.dp)
                        .clip(RoundedCornerShape(12.dp)) // Esquinas redondeadas
                        .border(2.dp, Color(0XFF351330)) // Borde alrededor de la imagen
                        .background(Color.White) // Fondo blanco
                        .clickable { isChecked.value = !isChecked.value } // Hace clic en el box para cambiar el estado
                ) {
                    // Añadir la imagen desde los recursos
                    Image(
                        painter = imagePainter,
                        contentDescription = "Imagen en el Box",
                        modifier = Modifier
                            .fillMaxWidth() // La imagen llena el ancho del contenedor
                            .height(300.dp) // La imagen llena la altura del contenedor
                            .clip(RoundedCornerShape(8.dp)) // Esquinas redondeadas
                            .padding(8.dp) // Añadir padding para no tapar los bordes
                    )
                }
            }
        }
    }
}