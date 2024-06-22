package com.vinicius.projetoparouimpar.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.projetoparouimpar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}