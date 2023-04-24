package com.example.healthypets.domain.login

import com.google.firebase.auth.FirebaseUser

interface HPLoginRepo {
    suspend fun singIn(email: String, password: String): FirebaseUser?

}