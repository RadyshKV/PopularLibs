package com.geekbrains.popularlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geekbrains.popularlib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCounter1.setOnClickListener {presenter.counterClick1()}
        binding.btnCounter2.setOnClickListener {presenter.counterClick2()}
        binding.btnCounter3.setOnClickListener {presenter.counterClick3()}
    }

    override fun setButtonText1(text: String) {
       binding.btnCounter1.text = text
    }

    override fun setButtonText2(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setButtonText3(text: String) {
        binding.btnCounter3.text = text
    }
}
