package net.simplifiedcoding.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import net.simplifiedcoding.MyApplication
import net.simplifiedcoding.R
import javax.inject.Inject

//#1 Add @Inject annotations to classes that you want to inject
//#2 Create a module for the classes that cannot be constructor injected e.g. Interfaces
//#3 Create Injectors for Activity/Fragments
//#4 Create App Component
//#5 Instantiate Dagger inside your application class, implement HasAndroidInjector and inject DispatchingAndroidInjector
//#6 Use AndroidInjection.inject to inject dependencies with the help Inject annotation

class AuthActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}