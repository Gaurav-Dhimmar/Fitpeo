package com.myapplication.app.service.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class BaseErrorModel {
    @SerializedName("success")
    @Expose
    private val success: Boolean? = null

    @SerializedName("confirm")
    @Expose
    private val confirm: String? = null

    @SerializedName("message")
    @Expose
    private val message: List<String>? = null

    @SerializedName("fields")
    @Expose
    private val fields: List<String>? = null
}