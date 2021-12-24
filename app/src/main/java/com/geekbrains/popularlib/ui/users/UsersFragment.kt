package com.geekbrains.popularlib.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentUsersBinding
import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.cache.RoomGithubUsersCache
import com.geekbrains.popularlib.domain.GithubUsersRepositoryImpl
import com.geekbrains.popularlib.remote.ApiHolder
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import com.geekbrains.popularlib.ui.base.BackButtonListener
import com.geekbrains.popularlib.ui.imageloading.GlideImageLoader
import com.geekbrains.popularlib.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter {
        App.instance.initUsersSubcomponent()
        App.instance.usersSubcomponent?.usersPresenter()!!
    }
    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(
            presenter.usersListPresenter,
            GlideImageLoader()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter
    }

    override fun showLoading() {
        binding.loadingView.isVisible = true
        binding.usersRecycler.isVisible = false
    }

    override fun hideLoading() {
        binding.loadingView.isVisible = false
        binding.usersRecycler.isVisible = true
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()


}
