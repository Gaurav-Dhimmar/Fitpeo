package com.myapplication.app.di.module

import com.myapplication.app.di.scope.MainScope
import com.myapplication.app.service.main.ServerApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal object MainModule {
    @MainScope
    @Provides
    fun provideMainApi(retrofit: Retrofit): ServerApi {
        return retrofit.create(ServerApi::class.java)
    }
}