package com.example.healthypets.data.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class HPLoginDataSource {
    suspend fun singIn(email:String, password: String): FirebaseUser?{
        val authResult = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
        return authResult.user
    }
}