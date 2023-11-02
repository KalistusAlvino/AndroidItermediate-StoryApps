package com.dicoding.picodiploma.loginwithanimation.view.main

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.data.remote.response.ListStoryItem
import com.dicoding.picodiploma.loginwithanimation.databinding.ItemRowStoryBinding
import com.dicoding.picodiploma.loginwithanimation.view.detail.DetailStoryActivity

class StoryAdapter : PagingDataAdapter<ListStoryItem,StoryAdapter.MyViewHolder>(DIFF_CALLBACK) {

    inner class MyViewHolder(internal val binding: ItemRowStoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (story : ListStoryItem){
            Glide.with(binding.root.context)
                .load(story.photoUrl)
                .into(binding.imgStory)
            binding.tvPengguna.text = story.name
            binding.tvDesc.text = story.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.MyViewHolder {
        val binding = ItemRowStoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryAdapter.MyViewHolder, position: Int) {
        val story = getItem(position)
        holder.bind(story!!)

        holder.itemView.setOnClickListener {
            val optionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    holder.itemView.context as Activity,
                    Pair(holder.binding.imgStory,"photo"),
                    Pair(holder.binding.tvPengguna,"user"),
                    Pair(holder.binding.tvDesc,"desc")
                )
            val moveDetailStory = Intent(holder.itemView.context, DetailStoryActivity::class.java)
            moveDetailStory.putExtra(DetailStoryActivity.EXTRA_DETAIL, story.id)
            holder.itemView.context.startActivity(moveDetailStory, optionsCompat.toBundle())
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>(){
            override fun areItemsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}