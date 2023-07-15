package com.myapplication.app.di.module

import android.content.Context
import com.myapplication.app.main.ui.detail.AlbumDetailsActivity
import com.myapplication.app.main.ui.detail.di.DetailsActivityComponent
import com.myapplication.app.main.ui.home.HomeActivity
import com.myapplication.app.main.ui.home.di.HomeActivityComponent
import com.myapplication.app.main.ui.splash.SplashActivity
import com.myapplication.app.main.ui.splash.di.SplashActivityComponent
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        SplashActivityComponent::class,
        HomeActivityComponent::class,
        DetailsActivityComponent::class
    ]
)

class AppModule(private val context: Context) {
    @AppScope
    @Provides
    fun provideContext(): Context = context

    @Provides
    @IntoMap
    @ClassKey(SplashActivity::class)
    fun provideSplashActivityBuilder(builder: SplashActivityComponent.Builder): ViewComponentBuilder<*, *> {
        return builder
    }

    @Provides
    @IntoMap
    @ClassKey(HomeActivity::class)
    fun provideHomeActivityBuilder(builder: HomeActivityComponent.Builder): ViewComponentBuilder<*, *> {
        return builder
    }

    @Provides
    @IntoMap
    @ClassKey(AlbumDetailsActivity::class)
    fun provideAlbumDetailsActivityBuilder(builder: DetailsActivityComponent.Builder): ViewComponentBuilder<*, *> {
        return builder
    }
}