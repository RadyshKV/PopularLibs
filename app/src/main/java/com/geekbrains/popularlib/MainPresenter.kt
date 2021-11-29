package com.geekbrains.popularlib

class MainPresenter (private val view: MainView){

    private val model = CountersModel()

    fun counterClick1() {
        val nextValue = model.increment(0)
        view.setButtonText1(nextValue.toString())
    }

    fun counterClick2() {
        val nextValue = model.increment(1)
        view.setButtonText2(nextValue.toString())
    }

    fun counterClick3() {
        val nextValue = model.increment(2)
        view.setButtonText3(nextValue.toString())
    }
}