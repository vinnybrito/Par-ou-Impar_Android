package com.vinicius.projetoparouimpar.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vinicius.projetoparouimpar.extensionsfiles.ONE
import com.vinicius.projetoparouimpar.extensionsfiles.TWO
import com.vinicius.projetoparouimpar.extensionsfiles.ZERO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EvenOrOddViewModel: ViewModel() {

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
        _numericValue.value = 0
    }

    fun evenOrOdd() {
        if(_numericValue.value?.rem(Int.TWO) == Int.ZERO) {
            if(_numericValue.value!! >= Int.ONE) {
                _resultValue.value = EVEN_MESSAGE
            }
        } else {
            _resultValue.value = ODD_MESSAGE
        }
    }

    companion object {
        private const val EVEN_MESSAGE = "PAR"
        private const val ODD_MESSAGE = "ÍMPAR"

        fun newFactory() = viewModelFactory {
            initializer { EvenOrOddViewModel() }
        }
    }
}