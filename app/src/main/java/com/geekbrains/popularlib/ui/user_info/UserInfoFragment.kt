package com.geekbrains.popularlib.ui.user_info

import android.os.Bundle
import android.view.View
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.databinding.FragmentUserInfoBinding
import com.geekbrains.popularlib.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserInfoFragment(position: Int): MvpAppCompatFragment(), UserInfoView, BackButtonListener {

    private val presenter by moxyPresenter { UserInfoPresenter(App.instance.router) }
    private var _binding: FragmentUserInfoBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun backPressed() : Boolean {
        presenter.backPressed()
        return true
    }

    override fun setLogin(login: String) {
        binding.tvLogin.text = login
    }
}