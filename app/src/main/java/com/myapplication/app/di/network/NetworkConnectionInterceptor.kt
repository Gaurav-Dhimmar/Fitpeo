package com.myapplication.app.di.network

import android.content.Context
import com.myapplication.app.di.network.NoInternetConnectionException
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val context: Context) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        try {
            val request = chain.request()
            return if (Connectivity.checkInternetConnection(context)) chain.proceed(request) else throw NoInternetConnectionException(
                context
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val request = chain.request()
        return if (Connectivity.checkInternetConnection(context)) chain.proceed(request) else throw NoInternetConnectionException(
            context
        )
    }
}