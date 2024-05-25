package com.vinicius.projetoparouimpar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vinicius.projetoparouimpar.extensionsfiles.ZERO
import com.vinicius.projetoparouimpar.databinding.FragmentEvenOrOddBinding
import kotlinx.coroutines.launch

class EvenOrOddFragment: Fragment() {

    private lateinit var binding: FragmentEvenOrOddBinding
    private val viewModel: EvenOrOddViewModel by viewModels { EvenOrOddViewModel.newFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEvenOrOddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupCollectors()
    }

    private fun setupCollectors() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.numericValue.collect { numericValue ->
                    with(binding) {
                        txtPrincipalValue.text = numericValue.toString()
                        txtResult.isGone = numericValue?.equals(Int.ZERO) ?: true
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.resultValue.collect { result ->
                    with(binding) {
                        txtResult.isVisible = result != null
                        txtResult.text = result.toString()
                    }
                }
            }
        }
    }

    private fun setupListeners() {
        with(binding) {
            btnPlus.setOnClickListener {
                viewModel.addValue()
            }
            btnMinus.setOnClickListener {
                viewModel.subtractValue()
            }
            btnCleanValues.setOnClickListener {
                viewModel.cleanValues()
            }
            btnReturnActivity.setOnClickListener {
                parentFragmentManager
                    .beginTransaction()
                    .remove(this@EvenOrOddFragment)
                    .commit()
            }
        }
    }

}