package net.simplifiedcoding.data.repository

import net.simplifiedcoding.data.network.UserApi

class UserRepository(
    private val api: UserApi
) : BaseRepository(api) {

    suspend fun getUser() = safeApiCall { api.getUser() }

}