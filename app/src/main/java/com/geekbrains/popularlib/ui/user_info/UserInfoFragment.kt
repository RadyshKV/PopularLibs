package com.geekbrains.popularlib.ui.user_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentUserInfoBinding
import com.geekbrains.popularlib.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserInfoFragment(): MvpAppCompatFragment(), UserInfoView, BackButtonListener {

    private val presenter by moxyPresenter { UserInfoPresenter(App.instance.router, ) }
    private var _binding: FragmentUserInfoBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getArguments(arguments)

    }

    override fun backPressed() = presenter.backPressed()
    override var nomer: Int = 222



    override fun setLogin(login: String) {
        binding.tvLogin.text = login
    }
}