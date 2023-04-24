package com.example.healthypets.presentation.login

sealed class HPLoginEvent{
    data class Login(val email: String, val password: String) : HPLoginEvent()

}
