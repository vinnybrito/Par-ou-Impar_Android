package com.vinicius.projetoparouimpar.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.vinicius.projetoparouimpar.databinding.FragmentEvenOrOddBinding

abstract class BaseEvenOrOddFragment<VB: ViewBinding> : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    protected abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

}