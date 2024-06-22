package com.vinicius.projetoparouimpar.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vinicius.projetoparouimpar.extensions.EVEN_MESSAGE
import com.vinicius.projetoparouimpar.extensions.ODD_MESSAGE
import com.vinicius.projetoparouimpar.extensions.ONE
import com.vinicius.projetoparouimpar.extensions.TWO
import com.vinicius.projetoparouimpar.extensions.ZERO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EvenOrOddViewModel : ViewModel() {

    private val _numericValue = MutableStateFlow<Int?>(null)
    val numericValue = _numericValue.asStateFlow()

    private val _resultValue = MutableStateFlow<String?>(null)
    val resultValue = _resultValue.asStateFlow()

    init {
        _numericValue.value = Int.ZERO
    }

    fun addValue() {
        _numericValue.value = _numericValue.value?.plus(Int.ONE)
        evenOrOdd()
    }

    fun subtractValue() {
        if (_numericValue.value!! > Int.ZERO) {
            _numericValue.value = _numericValue.value?.minus(Int.ONE)
            evenOrOdd()
        }
    }

    fun cleanValues() {
        _numericValue.value = Int.ZERO
    }

    private fun evenOrOdd() {
        if (_numericValue.value?.rem(Int.TWO) == Int.ZERO) {
            if (_numericValue.value!! >= Int.ONE) {
                _resultValue.value = EVEN_MESSAGE
            }
        } else {
            _resultValue.value = ODD_MESSAGE
        }
    }

    companion object {
        fun newFactory() = viewModelFactory {
            initializer { EvenOrOddViewModel() }
        }
    }
}