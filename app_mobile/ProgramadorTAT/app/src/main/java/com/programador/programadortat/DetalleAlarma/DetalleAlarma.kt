package com.programador.programadortat.DetalleAlarma


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.programador.programadortat.*
import kotlin.random.Random



@Composable
fun DetalleAlarma(nombre: String) {
    val randomVentas = Random.nextInt(1, 4)

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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // Asegúrate de que ocupa todo el tamaño disponible
                .padding(top = 16.dp), // Espacio superior
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Detalle de Alarma",
                    fontFamily = poppinsTitleStyle.fontFamily,
                    fontSize = poppinsTitleStyle.fontSize,
                    fontWeight = poppinsTitleStyle.fontWeight,
                    color = poppinsTitleStyle.color
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                LabelAndTextFieldStatic(nombre = nombre)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                DateInputFieldStatic()
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                TimeInputFieldStatic()
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                FrecuenceStatic("Frecuencia")
            }

            item {
                LabeledCheckboxStatic(
                    label = "Ubicacion",
                    imagePainter = painterResource(id = R.drawable.mapaandes) // Carga una imagen local desde recursos
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                LabelAndTextFieldStatic(nombre = "Venta de Aplicaciones web x$randomVentas")
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Editar(onClick = { /* TODO*/ }, nombreBoton = "Editar")
            }
        }
    }
}



@Composable
fun LabelAndTextFieldStatic(nombre: String) {
    Text(
        text = "Nombre de la alarma",
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
            .padding(top = 8.dp, bottom = 8.dp)
            .defaultMinSize(minHeight = 60.dp)
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
        // Reemplazar el TextField por un Text que muestra el texto
        Text(
            text = nombre, // Muestra el texto recibido
            modifier = Modifier
                .fillMaxWidth(), // Asegúrate de que el texto ocupe todo el ancho
            textAlign = TextAlign.Center, // Centra el texto dentro del Box
            fontFamily = poppinsBottonStyle.fontFamily,
            fontSize = poppinsBottonStyle.fontSize,
            fontWeight = poppinsBottonStyle.fontWeight,
            color = poppinsBottonStyle.color
        )
    }
}


@Composable
fun DateInputFieldStatic() {
    var dateState by remember { mutableStateOf("27/09/2024") }
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
            .background(Color.Transparent, shape = RoundedCornerShape(12.dp)),
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
fun TimeInputFieldStatic() {
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
            .background(Color.Transparent, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente el contenido
            modifier = Modifier.fillMaxWidth().padding(8.dp) // Ajuste de padding
        ) {
            Text(
                text = timeState.text.ifEmpty { "16:40" }, // Muestra el texto o placeholder
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
                    .size(25.dp) // Abre el TimePicker al hacer clic en la imagen
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
fun FrecuenceStatic(label: String) {
    // Inicializa estados de forma aleatoria, marcando entre 1 y 7 días
    val pressedStates = remember { mutableStateOf(List(7) { Random.nextBoolean() }) } // 7 para L, M, MI, J, V, S, D

    // Colores
    val circleColor = Color(0xFFE8CAA4)
    val overlayColor = Color(0xFF351330).copy(alpha = 0.3f)

    Text(
        text = label,
        modifier = Modifier.fillMaxWidth(), // Asegúrate de que el texto ocupe el ancho disponible
        textAlign = TextAlign.Start, // Alinea el texto a la izquierda
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
                    .border(2.dp, Color(0xFF351330), CircleShape),
                contentAlignment = Alignment.Center // Centra el contenido dentro del Box
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


@Composable
fun LabeledCheckboxStatic(
    checked: Boolean = true, // Siempre marcado
    label: String,
    imagePainter: Painter // Pintor de la imagen
) {
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
                    .background(Color(0xFF424254).copy(alpha = 0.5f)) // Fondo
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = null, // Manejamos el cambio en el Box
                    enabled = false,
                    colors = CheckboxDefaults.colors(
                        disabledCheckedColor = Color.Transparent,
                        checkedColor = Color.Transparent, // Sin color adicional cuando está seleccionado
                        uncheckedColor = Color.Transparent, // Sin color cuando no está seleccionado
                        checkmarkColor = Color(0xFF351330) // Color del checkmark
                    ),
                    modifier = Modifier
                        .size(14.dp) // Tamaño del checkbox
                        .align(Alignment.Center) // Centra el checkbox dentro del Box
                )
            }
        }

        // Contenedor para la imagen

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
                .border(2.dp, Color(0XFF351330)) // Borde azul alrededor de la imagen
                .background(Color.White) // Fondo blanco
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

@Composable
fun Editar(
    onClick: () -> Unit,
    nombreBoton: String,
    enabled: Boolean = false // Establecido en false por defecto
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFe8caa4)
            ),
            modifier = Modifier
                .width(250.dp)
                .clip(RoundedCornerShape(12.dp)),
            enabled = enabled // Usar el valor de enabled
        ) {
            Text(
                text = nombreBoton,
                fontFamily = poppinsBottonStyle.fontFamily,
                fontSize = poppinsBottonStyle.fontSize,
                fontWeight = poppinsBottonStyle.fontWeight,
                color = poppinsBottonStyle.color
            )
        }
    }
}

