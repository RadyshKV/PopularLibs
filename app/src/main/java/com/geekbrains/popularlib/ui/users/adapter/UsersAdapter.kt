package com.geekbrains.popularlib.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.popularlib.databinding.ItemUserBinding
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.ui.base.IListPresenter
import com.geekbrains.popularlib.ui.users.UserItemView
import com.geekbrains.popularlib.ui.users.UsersPresenter

class UsersAdapter(
    private val presenter: UsersPresenter.UsersListPresenter
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView {
        override fun setLogin(login: String) {
            vb.tvLogin.text = login
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
            itemView.setOnClickListener { presenter.itemClickListener }
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