package com.example.healthypets.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.setValue
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.healthypets.domain.login.HPLoginRepo
import com.example.healthypets.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HPLoginViewModel @Inject constructor(private val repository:HPLoginRepo): ViewModel(){
    private lateinit var auth: FirebaseAuth

    var state by mutableStateOf(HPLoginState())
        private set

    fun logIn(email: String, password: String) = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.singIn(email = email,password = password)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}