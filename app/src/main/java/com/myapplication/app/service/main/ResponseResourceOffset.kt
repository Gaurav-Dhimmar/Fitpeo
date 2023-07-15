package com.myapplication.app.service.main

import com.google.gson.GsonBuilder
import org.json.JSONException
import org.json.JSONObject


class ResponseResourceOffset<T> private constructor(
    val status: Status,
    val data: T?,
    errorModel: BaseErrorModel?,
    error: Throwable?,
    offset: Int
) {
    val error: Throwable?
    val errorModel: BaseErrorModel?
    var offset = -1

    init {
        this.errorModel = errorModel
        this.error = error
        this.offset = offset
    }

    override fun equals(obj: Any?): Boolean {
        if (obj!!.javaClass != javaClass || obj.javaClass != Resource::class.java) {
            return false
        }
        val resource = obj as ResponseResourceOffset<T>?
        if (resource!!.status != status) {
            return false
        }
        if (data != null) {
            if (resource.data !== data) {
                return false
            }
        }
        if (errorModel != null) {
            if (resource.errorModel !== errorModel) {
                return false
            }
        }
        return if (error != null) {
            resource.error === error
        } else true
    }

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T?, offset: Int): ResponseResourceOffset<T?> {
            return try {
                if (data != null) {
                    val jsonObject = JSONObject(data.toString())
                    if (jsonObject.getBoolean("success")) {
                        ResponseResourceOffset<T?>(Status.SUCCESS, data, null, null, offset)
                    } else {
                        val errorModel: BaseErrorModel = GsonBuilder().create().fromJson(
                            data.toString(),
                            BaseErrorModel::class.java
                        )
                        ResponseResourceOffset<T?>(Status.SUCCESS, null, errorModel, null, offset)
                    }
                } else {
                    ResponseResourceOffset<T?>(Status.SUCCESS, null, null, null, offset)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
                ResponseResourceOffset<T?>(Status.SUCCESS, null, null, null, offset)
            }
        }

        fun <T> error(throwable: Throwable?, offset: Int): ResponseResourceOffset<T?> {
            return ResponseResourceOffset(Status.ERROR, null, null, throwable, offset)
        }

        fun <T> loading(offset: Int): ResponseResourceOffset<T?> {
            return ResponseResourceOffset(Status.LOADING, null, null, null, offset)
        }
    }
}