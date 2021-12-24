package com.geekbrains.popularlib.ui.repo_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentRepoInfoBinding
import com.geekbrains.popularlib.model.GithubRepoModel
import com.geekbrains.popularlib.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoInfoFragment() : MvpAppCompatFragment(), RepoInfoView, BackButtonListener {

    private val presenter by moxyPresenter {
        App.instance.initRepoInfoSubcomponent()
        App.instance.repoInfoSubcomponent?.repoInfoPresenterFactory()?.presenter(repoModel)!!
    }
    private var _binding: FragmentRepoInfoBinding? = null
    private val binding
        get() = _binding!!

    private val repoModel : GithubRepoModel by lazy {
        requireArguments().getSerializable(REPO_MODEL) as GithubRepoModel
    }

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
    }

    override fun backPressed() = presenter.backPressed()

    override fun setRepoName(repoName: String?) {
        binding.name.text = repoName
    }

    override fun setRepoForks(repoForks: Int) {
        binding.fopsQnty.text = repoForks.toString()
    }

    companion object {
        private const val REPO_MODEL = "REPO_MODEL"
        fun newInstance(repoModel: GithubRepoModel): RepoInfoFragment {
            return RepoInfoFragment().apply {
                arguments = bundleOf(REPO_MODEL to repoModel)
            }
        }
    }
}


