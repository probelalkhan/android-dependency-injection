package net.simplifiedcoding

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import net.simplifiedcoding.di.AppModule
import net.simplifiedcoding.di.DaggerAppComponent
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector{

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}