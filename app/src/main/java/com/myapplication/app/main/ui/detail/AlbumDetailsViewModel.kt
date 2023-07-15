package com.myapplication.app.main.ui.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.myapplication.app.constants.AppConstants
import com.myapplication.app.databinding.ActivityDetailsBinding
import com.myapplication.app.main.base.BaseViewModel
import com.myapplication.app.service.model.responses.AlbumResponseModel
import com.myapplication.app.service.repository.HomeRepository

class AlbumDetailsViewModel(
    val userRepo: HomeRepository
) : BaseViewModel() {
    private var binding: ActivityDetailsBinding? = null
    var liveExperienceData: MutableLiveData<AlbumResponseModel> =
        MutableLiveData<AlbumResponseModel>()

    /**
     * @param binding use view file
     */
    fun setBinding(binding: ActivityDetailsBinding, intent: Intent?) {
        this.binding = binding
        if (intent!!.hasExtra(AppConstants.data)) {
            val data: AlbumResponseModel = GsonBuilder().create().fromJson(
                intent.getStringExtra(AppConstants.data), AlbumResponseModel::class.java
            )
            liveExperienceData.value = data
            binding.data = liveExperienceData.value
        }
    }
}