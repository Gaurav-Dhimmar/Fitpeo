package com.myapplication.app.main.base

data class AppError(
    val title:String?,
    val body: String?,
    val ex: Throwable?,
    val code: Int
)