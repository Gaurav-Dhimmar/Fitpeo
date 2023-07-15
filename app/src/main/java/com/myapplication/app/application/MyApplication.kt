package com.myapplication.app.application

import android.app.Application
import android.content.Context
import com.myapplication.app.BuildConfig
import com.myapplication.app.di.component.ComponentsHolder
import com.myapplication.app.preferences.AppPrefs
import timber.log.Timber

class MyApplication : Application() {
    var componentsHolder: ComponentsHolder? = null
//    var context: Context? = null
    var appPrefs: AppPrefs? = null

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()

        componentsHolder = ComponentsHolder(this)
        componentsHolder?.init()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appPrefs = AppPrefs(applicationContext)
    }

    override fun attachBaseContext(base: Context) {
        context = base
        super.attachBaseContext(base)
    }
}

fun getApp(context: Context): MyApplication? {
    try {
        return context.applicationContext as MyApplication
    } catch (ex: Throwable) {
        Timber.d(ex)
        return null
    }
}