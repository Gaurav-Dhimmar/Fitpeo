package com.myapplication.app.di.network

import android.content.Context
import com.myapplication.app.R
import java.io.IOException

class NoInternetConnectionException internal constructor(private val context: Context) :
    IOException() {

    override val message: String
        get() = context.resources.getString(R.string.no_internet_connection_body)
}


