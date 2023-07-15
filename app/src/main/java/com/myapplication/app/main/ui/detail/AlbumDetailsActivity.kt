package com.myapplication.app.main.ui.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.myapplication.app.R
import com.myapplication.app.databinding.ActivityDetailsBinding
import com.myapplication.app.main.base.BaseMainActivity
import com.myapplication.app.main.ui.detail.di.DetailsActivityComponent


class AlbumDetailsActivity : BaseMainActivity<ActivityDetailsBinding>() {
    override fun getLayoutId() = R.layout.activity_details

    override fun create(savedInstanceState: Bundle?) {
        viewModel.setBinding(binding, intent)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = resources.getString(R.string.albumDetails)

        binding.toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })
    }

    override fun getBaseVm() = viewModel

    private val viewModel: AlbumDetailsViewModel by lazy {
        ViewModelProvider(this, factory).get(AlbumDetailsViewModel::class.java)
    }

    override fun initDependencies() {
        getComponent<DetailsActivityComponent>()?.inject(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}