package net.simplifiedcoding.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import net.simplifiedcoding.MyApplication
import net.simplifiedcoding.R
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.di.AppContainer
import net.simplifiedcoding.di.AuthContainer
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {

    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (application as MyApplication).appContainer
        appContainer.authContainer = AuthContainer(appContainer.authRepository)
        setContentView(R.layout.activity_auth)
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.authContainer = null
    }
}