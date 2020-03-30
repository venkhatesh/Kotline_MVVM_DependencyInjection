package com.example.popularrepo

import android.app.Application
import com.example.popularrepo.di.components.AppComponent
import com.example.popularrepo.di.components.DaggerAppComponent
import dagger.internal.DaggerCollections

class BaseApplication : Application() {

    private lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
    fun getAppComponent() : AppComponent{
        return appComponent
    }
}