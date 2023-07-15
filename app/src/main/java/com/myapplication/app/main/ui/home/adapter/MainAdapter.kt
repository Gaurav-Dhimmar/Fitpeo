package com.myapplication.app.main.ui.home.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.app.databinding.RowTypicodeImagesBinding
import com.myapplication.app.service.model.responses.AlbumResponseModel

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    private var movies = mutableListOf<AlbumResponseModel>()
    private var activity: Activity? = null
    fun setMovieList(movies: List<AlbumResponseModel>, activity: Activity) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowTypicodeImagesBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie: AlbumResponseModel = movies[position]
        holder.binding.data = movie

//        holder.binding.rootLayout.setOnClickListener(View.OnClickListener { view ->
//            val intent = Intent(activity, DetailsActivity::class.java)
//            intent.putExtra(AppConstants.data, Gson().toJson(movie))
//            activity!!.startActivity(intent)
//        })

//        holder.binding.rootLayout.setOnClickListener(View.OnClickListener { view ->
//            // Do some work here
//            var toast = Toast.makeText(activity, "message", Toast.LENGTH_LONG)
//            toast.show()
////            val intent = Intent(activity, DetailsActivity::class.java)
////            intent.putExtra(AppConstants.data, Gson().toJson(movie))
////            activity!!.startActivity(intent)
//        })
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: RowTypicodeImagesBinding) : RecyclerView.ViewHolder(binding.root) {

}