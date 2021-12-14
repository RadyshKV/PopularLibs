package com.geekbrains.popularlib.ui.main

import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.R
import com.geekbrains.popularlib.ui.base.BackButtonListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity: MvpAppCompatActivity(R.layout.activity_main), MainView {


    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        //super.onBackPressed()

        supportFragmentManager.fragments.forEach{
            if (it is BackButtonListener && it.backPressed()){

                return
            }
        }
        presenter.backPressed()
    }
}