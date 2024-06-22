package com.vinicius.projetoparouimpar.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vinicius.projetoparouimpar.extensions.ZERO
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class EvenOrOddViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel by lazy { EvenOrOddViewModel() }

    @Test
    fun givenCleanValues_thenResetValuesToZero() = runTest {
        val resetedValue = Int.ZERO
        viewModel.cleanValues()
        assertEquals(resetedValue, viewModel.numericValue.value)
    }

    @Test
    fun `test evenOrOdd() with even number greater than or equal to 1`() = runTest {
        viewModel.addValue()
        viewModel.evenOrOdd()
        assertEquals("PAR", viewModel.resultValue.value)
    }

    @Test
    fun givenValueOnScreen_thenCheckIfValueIsEven() {
        // Arrange
        val displayedValue = 4
        // Act
        viewModel.evenOrOdd()

        // Assert
        assertEquals("PAR", viewModel.resultValue.value)
    }


}