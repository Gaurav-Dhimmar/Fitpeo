package com.myapplication.app.main.ui.home.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.myapplication.app.R
import com.myapplication.app.constants.AppConstants
import com.myapplication.app.databinding.RowTypicodeImagesBinding
import com.myapplication.app.main.ui.detail.AlbumDetailsActivity
import com.myapplication.app.service.model.responses.AlbumResponseModel

class AlbumListAdapter : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    private var albumList = mutableListOf<AlbumResponseModel>()
    private var activity: Activity? = null
    fun setMovieList(albumList: List<AlbumResponseModel>, activity: Activity) {
        this.albumList = albumList.toMutableList()
        this.activity = activity
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowTypicodeImagesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_typicode_images,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataPracticeLog: AlbumResponseModel = albumList[position]
        holder.binding.data = dataPracticeLog

        holder.binding.rootLayout.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(activity, AlbumDetailsActivity::class.java)
            intent.putExtra(AppConstants.data, Gson().toJson(dataPracticeLog))
            activity!!.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    inner class ViewHolder internal constructor(binding: RowTypicodeImagesBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        var binding: RowTypicodeImagesBinding

        init {
            this.binding = binding
        }

        override fun onClick(v: View) {
        }
    }
}
