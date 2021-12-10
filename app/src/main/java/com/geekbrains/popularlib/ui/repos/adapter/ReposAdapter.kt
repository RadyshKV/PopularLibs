package com.geekbrains.popularlib.ui.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.popularlib.databinding.ItemRepoBinding
import com.geekbrains.popularlib.ui.repos.RepoItemView
import com.geekbrains.popularlib.ui.repos.ReposPresenter


class ReposAdapter (
    private val presenter: ReposPresenter.ReposListPresenter
) : RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(private val vb: ItemRepoBinding) : RecyclerView.ViewHolder(vb.root),
        RepoItemView {
        override fun setName(name: String) {
            vb.name.text = name
        }

        override var pos: Int = -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            pos = position
        })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }
}