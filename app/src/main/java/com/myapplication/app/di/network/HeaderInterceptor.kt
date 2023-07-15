package com.myapplication.app.di.network

import android.content.Context
import com.myapplication.app.preferences.AppPrefs
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.atomic.AtomicReference

class HeaderInterceptor(val context: Context) : Interceptor {
    val preferences: AppPrefs = AppPrefs(context)

    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        var request: Request = chain.request()
        val builder: Headers.Builder = request.headers.newBuilder()
//        builder.add(AppConstants.Authorization, "Bearer 389|UFSKCb8bRiaFu4LMRESNqdcbhd8OQD6rTX4T6FLD")
        val headers: Headers = builder.build()
        request = request.newBuilder().headers(headers).build()
        val response = AtomicReference<Response>(chain.proceed(request))
        return response.get()
    }

    companion object {
        private const val TAG = "HeaderInterceptor"
    }
}