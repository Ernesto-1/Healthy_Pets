package com.example.healthypets.repository.login

import com.example.healthypets.data.remote.login.HPLoginDataSource
import com.google.firebase.auth.FirebaseUser

class HPLoginRepoImpl(private val datasource: HPLoginDataSource): HPLoginRepo {
    override suspend fun singIn(email: String, password: String): FirebaseUser? = datasource.logIn(email,password)
}