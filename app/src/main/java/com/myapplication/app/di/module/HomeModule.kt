package com.myapplication.app.di.module

import android.content.Context
import com.myapplication.app.di.module.AppScope
import com.myapplication.app.service.main.ServerApi
import com.myapplication.app.service.repository.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @AppScope
    @Provides
    internal fun provideRepo(
        context: Context,
        serverApi: ServerApi
    ): HomeRepository {
        return HomeRepository(context, serverApi)
    }
}