package com.vinicius.projetoparouimpar.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.projetoparouimpar.R
import com.vinicius.projetoparouimpar.databinding.ActivityMainBinding
import com.vinicius.projetoparouimpar.fragment.EvenOrOddFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnNextScreen.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fcv_even_or_odd, EvenOrOddFragment())
                .commit()
        }
    }

}