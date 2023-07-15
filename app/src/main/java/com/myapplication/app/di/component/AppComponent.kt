package com.myapplication.app.di.component

import com.myapplication.app.di.module.*
import com.myapplication.app.di.network.NetworkModule
import dagger.Component

@AppScope
@Component(
    modules = [
        SplashModule::class,
        AppModule::class,
        SharedPrefModule::class,
        NetworkModule::class,
        HomeModule::class,
    ]
)

interface AppComponent {
    fun injectComponentsHolder(componentsHolder: ComponentsHolder)
}