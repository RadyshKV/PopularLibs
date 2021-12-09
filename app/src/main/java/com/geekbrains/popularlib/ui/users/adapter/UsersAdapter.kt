package com.geekbrains.popularlib.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.popularlib.databinding.ItemUserBinding
import com.geekbrains.popularlib.ui.imageloading.ImageLoader
import com.geekbrains.popularlib.ui.users.UserItemView
import com.geekbrains.popularlib.ui.users.UsersPresenter

class UsersAdapter(
    private val presenter: UsersPresenter.UsersListPresenter,
    private val imageLoader: ImageLoader<ImageView>
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView {
        override fun setLogin(login: String) {
            vb.tvLogin.text = login
        }

        override fun loadImage(imageUrl: String) {
            imageLoader.loadInto(imageUrl, vb.userImage)
        }

        override var pos: Int = -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            pos = position
        })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }
}