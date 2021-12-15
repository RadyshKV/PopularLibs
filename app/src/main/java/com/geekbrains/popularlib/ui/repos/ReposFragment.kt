package com.geekbrains.popularlib.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentReposBinding
import com.geekbrains.popularlib.db.AppDatabase
import com.geekbrains.popularlib.db.cache.RoomGithubRepositoriesCache
import com.geekbrains.popularlib.domain.GithubReposRepositoryImpl
import com.geekbrains.popularlib.model.GithubUserModel
import com.geekbrains.popularlib.remote.ApiHolder
import com.geekbrains.popularlib.remote.connectivity.NetworkStatus
import com.geekbrains.popularlib.ui.base.BackButtonListener
import com.geekbrains.popularlib.ui.repos.adapter.ReposAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment: MvpAppCompatFragment(), ReposView, BackButtonListener {

    private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    private val presenter by moxyPresenter {
        ReposPresenter(
            userModel,
            App.instance.router,
            GithubReposRepositoryImpl(
                status,
                ApiHolder.retrofitService,
                RoomGithubRepositoriesCache(AppDatabase.instance)
            )
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

    private val userModel: GithubUserModel by lazy {
        requireArguments().getSerializable(KEY_USER_MODEL) as GithubUserModel
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

    companion object{
        private const val KEY_USER_MODEL = "KEY_USER_MODEL"
        fun newInstance(userModel: GithubUserModel): ReposFragment {
            return ReposFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to userModel)
            }
        }
    }

}