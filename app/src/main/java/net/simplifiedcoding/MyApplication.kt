package net.simplifiedcoding

import android.app.Application
import net.simplifiedcoding.di.AppContainer

class MyApplication : Application(){

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}