package com.myapplication.app.main.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.myapplication.app.databinding.ActivitySplashBinding
import com.myapplication.app.main.base.BaseViewModel
import com.myapplication.app.main.ui.home.HomeActivity
import com.myapplication.app.service.repository.UserRepository
import com.myapplication.app.preferences.AppPrefs
import io.reactivex.disposables.CompositeDisposable

class SplashViewModule(
    val appPrefs: AppPrefs,
    val userRepo: UserRepository
) : BaseViewModel() {

    private var activity: Activity? = null
    private var binding: ActivitySplashBinding? = null

    /**
     * @param binding use view file
     */
    fun setBinding(
        binding: ActivitySplashBinding, activity: Activity
    ) {
        this.binding = binding
        this.activity = activity
    }

    /**
     * LIVE DATA FOR HANDLE API RESPONSE
     */
//    open fun getLiveData(): MutableLiveData<Resource<GetProfileResponseModel?>> {
//        return liveData
//    }

    /**
     * TODO: API---> Workers/v1/getProfile
     * API REQUEST FOR WORKERS PROFILE
     */
    fun callGetProfileAPI() {
//        compositeDisposable.add(
//            userRepo.getProfileAPI()!!.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe { disposable -> liveData.setValue(Resource.loading()) }
//                .subscribe({ responseModel -> liveData.setValue(Resource.success(responseModel)) },
//                    { throwable -> liveData.setValue(Resource.error(throwable)) })
//        )
    }
}