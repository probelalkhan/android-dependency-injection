package net.simplifiedcoding.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.simplifiedcoding.R
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.data.network.AuthApi
import net.simplifiedcoding.data.network.RemoteDataSource
import net.simplifiedcoding.data.network.UserApi
import net.simplifiedcoding.data.repository.UserRepository
import net.simplifiedcoding.ui.auth.AuthActivity
import net.simplifiedcoding.ui.startNewActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    lateinit var userPreferences: UserPreferences
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val remoteDataSource = RemoteDataSource()
        val api = remoteDataSource.buildApi(UserApi::class.java, this)
        userPreferences = UserPreferences(this)
        viewModel = HomeViewModel(UserRepository(api))
    }

    fun performLogout() = lifecycleScope.launch {
        viewModel.logout()
        userPreferences.clear()
        startNewActivity(AuthActivity::class.java)
    }
}