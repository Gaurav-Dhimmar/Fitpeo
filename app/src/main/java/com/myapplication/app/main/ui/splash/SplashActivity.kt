package com.myapplication.app.main.ui.splash

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import com.myapplication.app.R
import com.myapplication.app.databinding.ActivitySplashBinding
import com.myapplication.app.main.base.BaseMainActivity
import com.myapplication.app.main.base.BaseViewModel
import com.myapplication.app.main.ui.home.HomeActivity
import com.myapplication.app.main.ui.splash.di.SplashActivityComponent
import com.myapplication.app.utils.ViewUtil
import kotlinx.coroutines.FlowPreview
import java.util.*

class SplashActivity : BaseMainActivity<ActivitySplashBinding>() {

    override fun getLayoutId() = R.layout.activity_splash

    override fun create(savedInstanceState: Bundle?) {
        ViewUtil.setFullScreen(this, true)
//        setTheme(R.style.AppTheme)
//        setStatusBarLight(false)
//        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorBackground));
//        viewModel.getLiveData()
//            .observe(this) { response: Resource<GetProfileResponseModel?> ->
//                consumeResponse(response)
//            }
        viewModel.setBinding(binding, this)
        bgThread()
    }

    private fun bgThread() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }


    override fun getBaseVm(): BaseViewModel {
        return viewModel
    }

    private val viewModel: SplashViewModule by lazy {
        ViewModelProvider(this, factory).get(SplashViewModule::class.java)
    }

    override fun initDependencies() {
        getComponent<SplashActivityComponent>()?.inject(this)
    }

    override fun getTheme(): Resources.Theme? {
        val theme: Resources.Theme = super.getTheme()
        theme.applyStyle(R.style.AppTheme, true)
        // you could also use a switch if you have many themes that could apply
        return theme
    }
}