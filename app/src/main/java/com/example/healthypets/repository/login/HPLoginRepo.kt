package com.example.healthypets.repository.login

import com.google.firebase.auth.FirebaseUser

interface HPLoginRepo {
    suspend fun singIn(email: String, password: String): FirebaseUser?
}