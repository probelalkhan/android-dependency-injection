package net.simplifiedcoding.ui.auth

import net.simplifiedcoding.data.repository.AuthRepository

class AuthViewModelFactory(
    private val authRepository: AuthRepository
) : Factory<AuthViewModel> {
    override fun create(): AuthViewModel {
        return AuthViewModel(authRepository)
    }
}