package com.geekbrains.popularlib

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.popularlib.databinding.ActivityMainBinding
import com.geekbrains.popularlib.domain.GithubUsersRepository
import com.geekbrains.popularlib.ui.users.UsersPresenter
import com.geekbrains.popularlib.ui.users.UsersView
import com.geekbrains.popularlib.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class UsersActivity : MvpAppCompatActivity(), UsersView {

    private val presenter by moxyPresenter { UsersPresenter(GithubUsersRepository()) }
    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(presenter.usersListPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usersRecycler.layoutManager = LinearLayoutManager(this)
        binding.usersRecycler.adapter  = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}
