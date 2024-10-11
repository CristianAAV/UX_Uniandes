package com.programador.programadortat

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


data class TextStyle(
    val fontFamily: FontFamily,
    val fontSize: TextUnit,
    val fontWeight: FontWeight,
    val color: Color
)

val poppinsAppStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins)),
    fontWeight = FontWeight.Bold,
    fontSize = 26.sp,
    color = Color(0xFF351330)
)
val poppinsTitleStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins)),
    fontWeight = FontWeight.Bold,
    fontSize = 22.sp,
    color = Color(0xFF351330)
)
val poppinsBottonStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins)),
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    color = Color(0xFF351330)
)
val poppinsLabelStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins)),
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    color = Color(0xFF351330)
)