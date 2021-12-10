package com.geekbrains.popularlib.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentReposBinding
import com.geekbrains.popularlib.domain.GithubReposRepositoryImpl
import com.geekbrains.popularlib.remote.ApiHolder
import com.geekbrains.popularlib.ui.base.BackButtonListener
import com.geekbrains.popularlib.ui.repos.adapter.ReposAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment: MvpAppCompatFragment(), ReposView, BackButtonListener {

    private val presenter by moxyPresenter {
        ReposPresenter(
            App.instance.router,
            GithubReposRepositoryImpl(ApiHolder.retrofitService)
        )
    }
    private var _binding: FragmentReposBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ReposAdapter(
            presenter.reposListPresenter
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getArguments(arguments)
        binding.reposRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecycler.adapter = adapter
    }

    override fun showLoading() {
        binding.loadingView.isVisible = true
        binding.reposRecycler.isVisible = false
    }

    override fun hideLoading() {
        binding.loadingView.isVisible = false
        binding.reposRecycler.isVisible = true
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()


}