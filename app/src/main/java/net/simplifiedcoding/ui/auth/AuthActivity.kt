package net.simplifiedcoding.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.simplifiedcoding.MyApplication
import net.simplifiedcoding.R
import net.simplifiedcoding.di.AppContainer
import net.simplifiedcoding.di.AuthContainer

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