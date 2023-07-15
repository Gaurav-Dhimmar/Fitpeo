package com.myapplication.app.di.module

import android.content.Context
import com.myapplication.app.di.module.AppScope
import com.myapplication.app.service.main.ServerApi
import com.myapplication.app.service.repository.*
import dagger.Module
import dagger.Provides

@Module
class SplashModule {
    @AppScope
    @Provides
    internal fun provideRepo(
        context: Context,
        serverApi: ServerApi
    ): UserRepository {
        return UserRepository(context, serverApi)
    }
}