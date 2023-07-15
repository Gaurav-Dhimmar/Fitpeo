package com.myapplication.app.di.network

import android.content.Context
import com.myapplication.app.di.module.AppScope
import com.myapplication.app.service.main.ServerApi
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.myapplication.app.constants.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule() {
    companion object {
        fun getNewRetrofit(client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setExclusionStrategies(HiddenAnnotationExclusionStrategy())
                            .setPrettyPrinting()
                            .setLenient()
                            .create()
                    )
                ).client(client)
                .build()
        }
    }

    @AppScope
    @Provides
    fun provideClient(
        interceptor: HttpLoggingInterceptor,
        context: Context
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .dispatcher(Dispatcher().apply { maxRequests = 1 })
            .addInterceptor(NetworkConnectionInterceptor(context))
            .addInterceptor(HeaderInterceptor(context))
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .build()
    }

    @AppScope
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @AppScope
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return getNewRetrofit(client)
    }

    @AppScope
    @Provides
    fun provideServerAPI(retrofit: Retrofit): ServerApi {
        return retrofit.create<ServerApi>(
            ServerApi::class.java
        )
    }
}

class HiddenAnnotationExclusionStrategy : ExclusionStrategy {
    override fun shouldSkipClass(clazz: Class<*>): Boolean {
        return clazz.getAnnotation(IgnoreField::class.java) != null
    }

    override fun shouldSkipField(f: FieldAttributes): Boolean {
        return f.getAnnotation(IgnoreField::class.java) != null
    }
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.CONSTRUCTOR
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class IgnoreField