package com.myapplication.app.main.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.myapplication.app.databinding.ActivityHomeBinding
import com.myapplication.app.main.base.BaseViewModel
import com.myapplication.app.main.ui.home.adapter.AlbumListAdapter
import com.myapplication.app.service.model.responses.AlbumResponseModel
import com.myapplication.app.service.repository.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val userRepo: HomeRepository
) : BaseViewModel() {

    //binding object
    @SuppressLint("StaticFieldLeak")
    private var activity: Activity? = null
    private var binding: ActivityHomeBinding? = null
    private val adapter = AlbumListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    private val errorMessage1: MutableLiveData<Int?> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var list: MutableLiveData<List<AlbumResponseModel>> = MutableLiveData<List<AlbumResponseModel>>()

    /**
     * @param binding use view file
     */
    fun setBinding(
        binding: ActivityHomeBinding, activity: Activity
    ) {
        this.binding = binding
        this.activity = activity
        this.list.value = ArrayList()
        tvAlbumPhotosApi()
    }

    /**
     * API CALL - https://jsonplaceholder.typicode.com/photos
     */
    private fun tvAlbumPhotosApi() {
        compositeDisposable.add(userRepo.loginAPI()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveArticleListStart() }
            .doOnTerminate { onRetrieveArticleListFinish() }
            .doOnSubscribe { disposable ->
                null
            }
            .subscribe(
                { responseBody -> onRetrieveArticleListSuccess(responseBody) }
            ) { throwable ->
                null
            })
    }

    private fun onRetrieveArticleListStart() {
        binding!!.progressBar.visibility = View.VISIBLE
        loadingVisibility.value = View.VISIBLE
        null.also { errorMessage1.value = it }
    }

    private fun onRetrieveArticleListFinish() {
        loadingVisibility.value = View.GONE
        binding!!.progressBar.visibility = View.GONE
    }

    private fun onRetrieveArticleListSuccess(articleList: List<AlbumResponseModel>) {
        binding!!.progressBar.visibility = View.GONE
        val layoutManager = GridLayoutManager(activity, 3)
        binding!!.rvAddExperience.layoutManager = layoutManager
        binding!!.rvAddExperience.adapter = adapter
        articleList.let { adapter.setMovieList(it, activity!!) }
    }
}