package com.example.healthypets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthypets.ui.home.HPHome
import com.example.healthypets.ui.login.HPLogin
import com.example.healthypets.ui.signup.HPSignUp
import com.example.healthypets.ui.theme.HealthyPetsTheme
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthyPetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    /*super.onStart()
                    val currentUser = auth.currentUser
                    if(currentUser != null){
                        navigationController.navigate("HPHome")
                    }*/
                    NavHost(navController = navigationController, startDestination = "HPLogin") {
                        composable("HPLogin") { HPLogin(navController = { navigationController.navigate("HPHome") }) }
                        composable("HPHome"){ HPHome() }
                        composable("HPSignUp"){ HPSignUp() }
                    }
                }
            }
        }
    }

}