package com.myapplication.app.main.ui.detail.di

import androidx.lifecycle.ViewModelProvider
import com.myapplication.app.di.module.ViewComponent
import com.myapplication.app.di.module.ViewComponentBuilder
import com.myapplication.app.di.module.ViewModule
import com.myapplication.app.main.ui.detail.AlbumDetailsActivity
import com.myapplication.app.main.ui.detail.AlbumDetailsViewModel
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
class DetailsActivityModule : ViewModule {
    @HomeScope
    @Provides
    internal fun provideFactory(
        userRepo: HomeRepository
    ): ViewModelProvider.Factory {
        return viewModelFactory {
            AlbumDetailsViewModel(
                userRepo
            )
        }
    }
}

@HomeScope
@Subcomponent(modules = [DetailsActivityModule::class])
interface DetailsActivityComponent : ViewComponent<AlbumDetailsActivity> {
    @Subcomponent.Builder
    interface Builder :
        ViewComponentBuilder<DetailsActivityComponent, DetailsActivityModule>
}