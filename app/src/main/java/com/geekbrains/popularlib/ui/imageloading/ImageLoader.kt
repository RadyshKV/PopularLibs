package com.geekbrains.popularlib.ui.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}