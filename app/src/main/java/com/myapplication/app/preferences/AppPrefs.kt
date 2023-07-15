package com.myapplication.app.preferences

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class AppPrefs(val context: Context) : BasePreferences() {

    companion object {
        const val USER_ID = "user_id"
        const val PROFILE_GSON = "profile_gson"
        const val TOKEN = "token"
        const val USER_GSON = "user_gson"
        const val IS_Worker = "is_worker"
        const val IS_COMPANY_SUPERVISOR = "is_company_supervisor"
        const val IS_ORG_SUPERVISOR = "is_org_supervisor"
    }

    fun setString(key: String?, value: String?) {
        putString(context, key, value)
    }

    fun getString(key: String?): String {
        return getString(context, key)
    }

    fun setLong(key: String?, value: Long) {
        putLong(context, key, value)
    }

    fun getLong(key: String?): Long {
        return getLong(context, key)
    }

    fun setBoolean(key: String?, value: Boolean) {
        putBoolean(context, key, value)
    }

    fun getBoolean(key: String?): Boolean {
        return getBoolean(context, key)
    }

    fun setFloat(key: String?, value: Float) {
        putFloat(context, key, value)
    }

    fun getFloat(key: String?): Float {
        return getFloat(context, key)
    }

    fun setInt(key: String?, value: Int) {
        putInt(context, key, value)
    }

    fun getInt(key: String?): Int {
        return getInt(context, key)
    }

    fun removeRecord(key: String?) {
        return removeRecord(context, key)
    }

    fun clearAll() {
        clearAll(context)
    }
}