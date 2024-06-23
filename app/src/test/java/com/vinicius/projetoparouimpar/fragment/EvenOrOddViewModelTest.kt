package com.vinicius.projetoparouimpar.fragment

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class EvenOrOddViewModelTest {

    private val viewModel by lazy { EvenOrOddViewModel() }

    @Test
    fun givenAddvalue_when() {
        assertEquals(0, viewModel.numericValue.value)

        viewModel.addValue()
        assertEquals(1, viewModel.numericValue.value)

        viewModel.addValue()
        assertEquals(2, viewModel.numericValue.value)

        viewModel.addValue()
        assertEquals(3, viewModel.numericValue.value)
    }

    @Test
    fun givenCleanValues_thenResetValuesToZero() {
        viewModel.addValue()
        viewModel.cleanValues()
        assertEquals(0, viewModel.numericValue.value)
    }

}