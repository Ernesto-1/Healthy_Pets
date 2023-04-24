package com.example.healthypets.ui.login

import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.healthypets.R
import com.example.healthypets.presentation.login.HPLoginEvent
import com.example.healthypets.presentation.login.HPLoginViewModel
import com.example.healthypets.ui.theme.Black
import com.example.healthypets.ui.theme.BtnGreen
import com.example.healthypets.ui.theme.White
import com.example.healthypets.utils.Resource
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HPLogin(navController: () -> Unit = {}, viewModel: HPLoginViewModel = hiltViewModel()) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var hidden by rememberSaveable { mutableStateOf(true) } //1
    val color = Color(Black.value)
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = "img_login",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.dise_o_sin_t_tulo),
                contentDescription = "img_login",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Fit
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electronico") },
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

            )
            Spacer(modifier = Modifier.height(20.dp))
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

            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.wrapContentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ButtonDefault(
                        textButton = "Iniciar sesion", modifier = Modifier
                            .width(282.dp)
                            .clip(RoundedCornerShape(12.dp))
                    ) {
                        //navController.invoke()
                        viewModel.logIn(email = email, password = password)
                            .observe(lifecycleOwner.value) { result ->
                                when (result) {
                                    is Resource.Loading -> {}
                                    is Resource.Success -> {
                                        navController.invoke()
                                        result.data?.let { Log.d("cfvgbhnjl", it.uid) }

                                    }
                                    is Resource.Failure -> {
                                        Log.d("cfvgbhnjl",  result.exception.toString())

                                    }
                                    else -> {}
                                }
                            }
                    }
                    Text(
                        text = "Olvide mi contraseña",
                        color = White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {})
                }
                Text(
                    text = "Registrarme",
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { }
                        .padding(bottom = 10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun HPLoginView() {
    HPLogin()
}

@Composable
fun EmailLogin() {
    var email by rememberSaveable { mutableStateOf("") }
    val color = Color(Black.value)
    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Correo electronico") },
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

    )
}

@Composable
fun PasswordLogin(password:String) {
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
    ) {
        Text(
            text = textButton ?: ""
        )
    }
}