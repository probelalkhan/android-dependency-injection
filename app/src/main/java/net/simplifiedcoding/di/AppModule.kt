package net.simplifiedcoding.di

import android.content.Context
import dagger.Module
import dagger.Provides
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.data.network.AuthApi
import net.simplifiedcoding.data.network.RemoteDataSource
import javax.inject.Singleton

@Module
class AppModule(
   private val context: Context
) {

    @Singleton
    @Provides
    fun provideAuthApi(remoteDataSource: RemoteDataSource): AuthApi {
        return remoteDataSource.buildApi(AuthApi::class.java, context)
    }

    @Singleton
    @Provides
    fun provideUserPreferences(): UserPreferences {
        return UserPreferences(context)
    }
}