package com.cheonajjang.uas0710.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.cheonajjang.uas0710.R
import com.cheonajjang.uas0710.data.model.User
import com.cheonajjang.uas0710.databinding.ItemMainBinding


class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    private val list = ArrayList<User>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(users: ArrayList<User>) {
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(user)
            }

            binding.apply {
                Glide.with(itemView)
                    .load(user.avatar_url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(itemAvatar)

                itemLogin.text = user.login
                itemDescription.text = user.html_url
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}