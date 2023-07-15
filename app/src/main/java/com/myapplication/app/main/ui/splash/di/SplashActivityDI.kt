package com.myapplication.app.main.ui.splash.di

import androidx.lifecycle.ViewModelProvider
import com.myapplication.app.di.module.ViewComponent
import com.myapplication.app.di.module.ViewComponentBuilder
import com.myapplication.app.di.module.ViewModule
import com.myapplication.app.main.ui.splash.SplashActivity
import com.myapplication.app.main.ui.splash.SplashViewModule
import com.myapplication.app.service.repository.UserRepository
import com.myapplication.app.preferences.AppPrefs
import com.myapplication.app.utils.viewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SplashScope

@Module
class SplashActivityModule : ViewModule {
    @SplashScope
    @Provides
    internal fun provideFactory(
        appPrefs: AppPrefs,
        userRepo: UserRepository
    ): ViewModelProvider.Factory {
        return viewModelFactory {
            SplashViewModule(
                appPrefs,
                userRepo
            )
        }
    }
}

@SplashScope
@Subcomponent(modules = [SplashActivityModule::class])
interface SplashActivityComponent : ViewComponent<SplashActivity> {
    @Subcomponent.Builder
    interface Builder : ViewComponentBuilder<SplashActivityComponent, SplashActivityModule>
}