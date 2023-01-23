package com.example.healthypets.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthypets.R
import com.example.healthypets.presentation.login.HPLoginViewModel
import com.example.healthypets.ui.theme.Black
import com.example.healthypets.ui.theme.BtnGreen
import com.example.healthypets.ui.theme.White

@Composable
fun HPLogin(
    viewModel: HPLoginViewModel
){

     Box(modifier = Modifier.fillMaxSize()) {
         Image(
             painter = painterResource(id = R.drawable.background_login), contentDescription = "img_login", modifier = Modifier
                 .fillMaxSize(), contentScale = ContentScale.Crop
         )
         Column(
             modifier = Modifier
                 .fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             Image(
                 painter = painterResource(id = R.drawable.dise_o_sin_t_tulo), contentDescription = "img_login", modifier = Modifier
                     .fillMaxWidth() ,
                 contentScale = ContentScale.Fit
             )
             
             CorreoLogin()
             Spacer(modifier = Modifier.height(20.dp))
             PasswordLogin()
             Spacer(modifier = Modifier.height(10.dp))
             Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceBetween,horizontalAlignment = Alignment.CenterHorizontally) {
                 Text(text = "Olvide mi contraseña", color = White, modifier = Modifier.clickable {  })
                 ButtonDefault(textButton = "Entrar", modifier = Modifier.wrapContentSize()) {
                 }
                 Text(text = "Registrarme", color = White, fontSize = 14.sp,modifier = Modifier.clickable {  }.padding(bottom = 10.dp))
             }


         }



     }
}

@Composable
fun CorreoLogin(){
    var correo by rememberSaveable { mutableStateOf("") }
    val color = Color(Black.value)
    TextField(
        value = correo,
        onValueChange = { correo = it },
        label = { Text("Correo electronico") },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = color,
            backgroundColor = Color.White,
            focusedLabelColor = color.copy(alpha = ContentAlpha.high),
            focusedIndicatorColor = Color.Transparent,
            cursorColor = color
        ), modifier = Modifier.clip(RoundedCornerShape(12.dp)).width(282.dp)

    )
}

@Composable
fun PasswordLogin() {
    var password by rememberSaveable { mutableStateOf("") }
    var hidden by rememberSaveable { mutableStateOf(true) } //1
    val color = Color(Black.value)
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3
        trailingIcon = {
            if (password != ""){
                IconButton(onClick = { hidden = !hidden }) {
                    val vector = painterResource(//5
                        if (hidden) R.drawable.ic_baseline_remove_red_eye_24
                        else R.drawable.ic_baseline_visibility_off_24
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
        ), modifier = Modifier.clip(RoundedCornerShape(12.dp)).width(282.dp)

    )
}

@Composable
fun ButtonDefault(
    modifier: Modifier = Modifier,
    textButton: String? = "textBtn",
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = BtnGreen,
            contentColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .width(108.dp)
    ) {
        Text(
            text = textButton ?: "", modifier = modifier.wrapContentSize()
        )
    }
}