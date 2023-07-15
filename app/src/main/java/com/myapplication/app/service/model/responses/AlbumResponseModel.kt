package com.myapplication.app.service.model.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AlbumResponseModel {
    @SerializedName("albumId")
    @Expose
    val albumId = 0

    @SerializedName("id")
    @Expose
    val id = 0

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("url")
    @Expose
    val url: String? = null

    @SerializedName("thumbnailUrl")
    @Expose
    val thumbnailUrl: String? = null
}