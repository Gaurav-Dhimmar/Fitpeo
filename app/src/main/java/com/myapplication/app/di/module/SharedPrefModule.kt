package com.myapplication.app.di.module

import android.content.Context
import com.myapplication.app.di.module.AppScope
import com.myapplication.app.preferences.AppPrefs
import dagger.Module
import dagger.Provides

@Module
class SharedPrefModule {
    @AppScope
    @Provides
    internal fun provide(context: Context): AppPrefs {
        return AppPrefs(context)
    }
}