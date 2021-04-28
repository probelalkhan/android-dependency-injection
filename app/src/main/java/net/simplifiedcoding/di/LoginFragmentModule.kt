package net.simplifiedcoding.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.simplifiedcoding.ui.auth.LoginFragment

@Module
abstract class LoginFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragmentInjector() : LoginFragment

}