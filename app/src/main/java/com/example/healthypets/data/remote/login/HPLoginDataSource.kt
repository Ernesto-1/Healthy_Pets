package com.example.healthypets.data.remote.login

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class HPLoginDataSource @Inject constructor(private val firebaseAuth: FirebaseAuth) {
    suspend fun logIn(email:String, password: String): FirebaseUser?{
        val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return authResult.user
    }
}