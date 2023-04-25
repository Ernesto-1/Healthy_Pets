package com.example.healthypets.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthypets.R
import com.example.healthypets.ui.login.ButtonDefault
import com.example.healthypets.ui.theme.BackGroud
import com.example.healthypets.ui.theme.Black

@Preview(showBackground = true)
@Composable
fun HPSignUp() {
    var name by rememberSaveable { mutableStateOf("") }
    var paternalLastName by rememberSaveable { mutableStateOf("") }
    var maternalLastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var hidden by rememberSaveable { mutableStateOf(true) }
    var hiddenConfirm by rememberSaveable { mutableStateOf(true) }


    val color = Color(Black.value)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroud),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(170.dp), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Crear nueva cuenta",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color,
                    backgroundColor = Color.White,
                    focusedLabelColor = color.copy(alpha = ContentAlpha.high),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = color
                ), modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(282.dp)
                    .padding(vertical = 5.dp)

            )
            TextField(
                value = paternalLastName,
                onValueChange = { paternalLastName = it },
                label = { Text("Apellido paterno") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color,
                    backgroundColor = Color.White,
                    focusedLabelColor = color.copy(alpha = ContentAlpha.high),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = color
                ), modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(282.dp)
                    .padding(vertical = 5.dp)

            )
            TextField(
                value = maternalLastName,
                onValueChange = { maternalLastName = it },
                label = { Text("Apellido materno") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color,
                    backgroundColor = Color.White,
                    focusedLabelColor = color.copy(alpha = ContentAlpha.high),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = color
                ), modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(282.dp)
                    .padding(vertical = 5.dp)

            )
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("correo electronico") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color,
                    backgroundColor = Color.White,
                    focusedLabelColor = color.copy(alpha = ContentAlpha.high),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = color
                ), modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(282.dp)
                    .padding(vertical = 5.dp)

            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3
                trailingIcon = {
                    if (password != "") {
                        IconButton(onClick = { hidden = !hidden }) {
                            val vector = painterResource(
                                if (hidden) R.drawable.ic_baseline_remove_red_eye_24 else R.drawable.ic_baseline_visibility_off_24
                            )
                            val description = if (hidden) "Ocultar contraseña" else "Revelar contraseña" //6
                            Icon(painter = vector, contentDescription = description)
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color,
                    backgroundColor = Color.White,
                    focusedLabelColor = color.copy(alpha = ContentAlpha.high),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = color
                ), modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(282.dp)
                    .padding(vertical = 5.dp)

            )
            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Contraseña") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                visualTransformation = if (hiddenConfirm) PasswordVisualTransformation() else VisualTransformation.None,//3
                trailingIcon = {
                    if (password != "") {
                        IconButton(onClick = { hiddenConfirm = !hiddenConfirm }) {
                            val vector = painterResource(
                                if (hiddenConfirm) R.drawable.ic_baseline_remove_red_eye_24 else R.drawable.ic_baseline_visibility_off_24
                            )
                            val description = if (hiddenConfirm) "Ocultar contraseña" else "Revelar contraseña" //6
                            Icon(painter = vector, contentDescription = description)
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color,
                    backgroundColor = Color.White,
                    focusedLabelColor = color.copy(alpha = ContentAlpha.high),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = color
                ), modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(282.dp)
                    .padding(vertical = 5.dp)

            )
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                ButtonDefault(textButton = "Registrarme", modifier = Modifier
                    .width(282.dp)
                    .padding(bottom = 25.dp)
                    .clip(RoundedCornerShape(12.dp))) {

                }
            }
        }

    }
}