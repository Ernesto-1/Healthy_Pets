package com.example.healthypets.repository.login

import com.example.healthypets.data.remote.HPLoginDataSource
import com.google.firebase.auth.FirebaseUser

class HPLoginRepoImpl(private val datasource: HPLoginDataSource): HPLoginRepo {
    override suspend fun singIn(email: String, password: String): FirebaseUser? = datasource.singIn(email,password)
}