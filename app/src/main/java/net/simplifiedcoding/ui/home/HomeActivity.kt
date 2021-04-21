package net.simplifiedcoding.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import net.simplifiedcoding.R
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.data.network.RemoteDataSource
import net.simplifiedcoding.data.network.UserApi
import net.simplifiedcoding.data.repository.UserRepository
import net.simplifiedcoding.ui.auth.AuthActivity
import net.simplifiedcoding.ui.startNewActivity

class HomeActivity : AppCompatActivity() {

    lateinit var userPreferences: UserPreferences
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userPreferences = UserPreferences(this)
        val remoteDataSource = RemoteDataSource()
        val api = remoteDataSource.buildApi(UserApi::class.java,this)
        val authRepository = UserRepository(api)
        viewModel = HomeViewModel(authRepository)
    }

    fun performLogout() = lifecycleScope.launch {
        viewModel.logout()
        userPreferences.clear()
        startNewActivity(AuthActivity::class.java)
    }
}