package com.myapplication.app.main.ui.home.di

import androidx.lifecycle.ViewModelProvider
import com.myapplication.app.di.module.ViewComponent
import com.myapplication.app.di.module.ViewComponentBuilder
import com.myapplication.app.di.module.ViewModule
import com.myapplication.app.main.ui.home.HomeActivity
import com.myapplication.app.main.ui.home.HomeViewModel
import com.myapplication.app.service.repository.HomeRepository
import com.myapplication.app.utils.viewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HomeScope

@Module
class HomeActivityModule : ViewModule {
    @HomeScope
    @Provides
    internal fun provideFactory(
        userRepo: HomeRepository
    ): ViewModelProvider.Factory {
        return viewModelFactory {
            HomeViewModel(
                userRepo
            )
        }
    }
}

@HomeScope
@Subcomponent(modules = [HomeActivityModule::class])
interface HomeActivityComponent : ViewComponent<HomeActivity> {
    @Subcomponent.Builder
    interface Builder :
        ViewComponentBuilder<HomeActivityComponent, HomeActivityModule>
}