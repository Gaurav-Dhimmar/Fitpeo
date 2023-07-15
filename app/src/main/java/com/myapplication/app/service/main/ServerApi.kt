package com.myapplication.app.service.main

import com.google.gson.GsonBuilder
import com.myapplication.app.constants.AppConstants
import com.myapplication.app.di.network.HiddenAnnotationExclusionStrategy
import com.myapplication.app.service.model.responses.AlbumResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServerApi {
    @GET("photos")
    fun loginAPI(): Observable<List<AlbumResponseModel>>

    @GET("photos")
    fun getAllMovies(): Call<List<AlbumResponseModel>>

    companion object {

        var retrofitService: ServerApi? = null

        fun getInstance(): ServerApi {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
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
                    ).build()
                retrofitService = retrofit.create(ServerApi::class.java)
            }
            return retrofitService!!
        }
    }
}