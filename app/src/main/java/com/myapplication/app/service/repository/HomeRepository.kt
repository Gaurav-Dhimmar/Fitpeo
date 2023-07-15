package com.myapplication.app.service.repository

import android.content.Context
import com.myapplication.app.service.main.ServerApi
import com.myapplication.app.service.model.responses.AlbumResponseModel
import io.reactivex.Observable

class HomeRepository(val context: Context, private val serverApi: ServerApi) {
    fun loginAPI(): Observable<List<AlbumResponseModel>> {
        return serverApi.loginAPI()
    }

    fun getAllMovies() = serverApi.getAllMovies()
}