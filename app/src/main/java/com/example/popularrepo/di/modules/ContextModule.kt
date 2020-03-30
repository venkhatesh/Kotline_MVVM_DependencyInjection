package com.example.popularrepo.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier

@Module
abstract class ContextModule(context:Context) {

    @Binds
    internal abstract fun bindContext(application: Application):Context
}