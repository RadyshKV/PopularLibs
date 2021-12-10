package com.geekbrains.popularlib.ui.repo_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentRepoInfoBinding
import com.geekbrains.popularlib.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoInfoFragment() : MvpAppCompatFragment(), RepoInfoView, BackButtonListener {

    private val presenter by moxyPresenter { RepoInfoPresenter(App.instance.router) }
    private var _binding: FragmentRepoInfoBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getArguments(arguments)
    }

    override fun backPressed() = presenter.backPressed()

    override fun setRepoName(repoName: String) {
        binding.name.text = repoName
    }

    override fun setRepoForks(repoForks: Int) {
        binding.fopsQnty.text = repoForks.toString()
    }
}