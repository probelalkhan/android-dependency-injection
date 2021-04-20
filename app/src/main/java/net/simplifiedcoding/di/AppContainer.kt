package net.simplifiedcoding.di

import android.content.Context
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.data.network.AuthApi
import net.simplifiedcoding.data.network.RemoteDataSource
import net.simplifiedcoding.data.repository.AuthRepository

class AppContainer(context: Context) {
    private val remoteDataSource = RemoteDataSource()
    private val api = remoteDataSource.buildApi(AuthApi::class.java, context)
    private val preferences = UserPreferences(context)

    val authRepository = AuthRepository(api, preferences)

    var authContainer: AuthContainer? = null
}