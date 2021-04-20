package net.simplifiedcoding.di

import net.simplifiedcoding.data.repository.AuthRepository
import net.simplifiedcoding.ui.auth.AuthViewModelFactory

class AuthContainer(
    authRepository: AuthRepository
) {
    val authViewModelFactory = AuthViewModelFactory(authRepository)
}