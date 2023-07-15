package com.myapplication.app.main.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.myapplication.app.R
import com.myapplication.app.databinding.ActivityHomeBinding
import com.myapplication.app.main.base.BaseMainActivity
import com.myapplication.app.main.ui.home.di.HomeActivityComponent

class HomeActivity : BaseMainActivity<ActivityHomeBinding>() {
    override fun getLayoutId() = R.layout.activity_home

    override fun create(savedInstanceState: Bundle?) {
        viewModel.setBinding(binding, this)
    }

    override fun getBaseVm() = viewModel

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, factory).get(HomeViewModel::class.java)
    }

    override fun initDependencies() {
        getComponent<HomeActivityComponent>()?.inject(this)
    }
}