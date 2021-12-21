package com.geekbrains.popularlib.ui.main

import android.os.Bundle
import com.geekbrains.popularlib.App
import com.geekbrains.popularlib.R
import com.geekbrains.popularlib.ui.base.BackButtonListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter {
        App.instance.appComponent.mainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        //super.onBackPressed()

        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {

                return
            }
        }
        presenter.backPressed()
    }
}