package com.example.popularrepo.di.components

import com.example.popularrepo.di.modules.ContextModule
import com.example.popularrepo.di.modules.NetworkModule
import com.example.popularrepo.ui.main.MainActivity
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, ContextModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity?)

}