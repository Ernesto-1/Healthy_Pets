package com.example.healthypets.domain.login

import com.example.healthypets.data.remote.login.HPLoginDataSource
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class HPLoginRepoImpl @Inject constructor(private val dataSource: HPLoginDataSource): HPLoginRepo{
    override suspend fun singIn(email: String, password: String): FirebaseUser? = dataSource.logIn(email = email, password = password)
}