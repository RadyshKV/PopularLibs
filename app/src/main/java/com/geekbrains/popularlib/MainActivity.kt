package com.geekbrains.popularlib

import android.os.Bundle
import com.geekbrains.popularlib.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity


class MainActivity : MvpAppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
