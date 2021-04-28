package net.simplifiedcoding.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import net.simplifiedcoding.MyApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AuthActivityModule::class,
        AndroidInjectionModule::class,
        LoginFragmentModule::class,
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(application: MyApplication)
}