package com.example.popularrepo.di.modules

import com.example.popularrepo.remote.NetworkService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
 object NetworkModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create<NetworkService>(NetworkService::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://github-trending-api.now.sh")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).build()
    }


}
