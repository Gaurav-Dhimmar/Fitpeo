package com.myapplication.app.utils

import android.content.Context
import android.content.ContextWrapper
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
    }

fun Context.isOnline(): Boolean {
    val manager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (manager == null) {
        false
    } else {
        val is3g = manager.getNetworkInfo(0)!!.isConnectedOrConnecting
        val isWifi = manager.getNetworkInfo(1)!!.isConnectedOrConnecting
        is3g || isWifi
    }
}

fun Context.showKeyboard(view: View?) {
    val inputManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager

    inputManager?.showSoftInput(view, 0)
}

fun Context.hideKeyboard(view: View?) {
    view?.let {
        val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
