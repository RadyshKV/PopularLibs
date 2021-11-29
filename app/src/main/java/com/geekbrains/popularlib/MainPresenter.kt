package com.geekbrains.popularlib

import moxy.MvpPresenter

class MainPresenter(
    private val model: CountersModel
): MvpPresenter<MainView>(){

    fun counterClick1() {
        val nextValue = model.increment1()
        viewState.setButtonText1(nextValue.toString())
    }

    fun counterClick2() {
        val nextValue = model.increment2()
        viewState.setButtonText2(nextValue.toString())
    }

    fun counterClick3() {
        val nextValue = model.increment3()
        viewState.setButtonText3(nextValue.toString())
    }
}