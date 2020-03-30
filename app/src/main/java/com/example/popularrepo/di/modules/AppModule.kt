package com.example.popularrepo.di.modules

import android.content.Context
import com.example.popularrepo.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton // Annotation informs Dagger compiler that the instance should be created only once in the entire lifecycle of the application.
    @Provides // Annotation informs Dagger compiler that this method is the constructor for the Context return type.
    @AppContext
    fun provideContext(app: BaseApplication): Context = app
}