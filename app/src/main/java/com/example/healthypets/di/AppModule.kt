package com.example.healthypets.di

import com.example.healthypets.domain.login.HPLoginRepo
import com.example.healthypets.domain.login.HPLoginRepoImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun providesLoginRepository(repoLogin: HPLoginRepoImpl): HPLoginRepo

    companion object {
        @Provides
        @Singleton
        fun provideFirestore() = FirebaseAuth.getInstance()

    }


}