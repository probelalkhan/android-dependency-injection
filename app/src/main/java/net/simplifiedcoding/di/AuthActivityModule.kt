package net.simplifiedcoding.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.simplifiedcoding.ui.auth.AuthActivity
import net.simplifiedcoding.ui.auth.LoginFragment

@Module
abstract class AuthActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragmentInjector() : AuthActivity

}