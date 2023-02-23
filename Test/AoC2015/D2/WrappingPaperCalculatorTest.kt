package AoC2015.D2


import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotEquals
import org.testng.annotations.Test

class WrappingPaperCalculatorTest {

    @Test
    fun calculateRibbonRequiredTest() {
        val input1 = listOf("2x3x4")
        val input2 = listOf("1x1x10")

        assertEquals(34, calculateRibbonRequired(input1))
        assertEquals(14, calculateRibbonRequired(input2))
        assertNotEquals(14, calculateRibbonRequired(input1))
    }

    @Test
    fun calculateRibbonRequired2Test() {
        val input1 = listOf("2x3x4")
        val input2 = listOf("1x1x10")

        assertEquals(34, calculateRibbonRequired2(input1))
        assertEquals(14, calculateRibbonRequired2(input2))
        assertNotEquals(14, calculateRibbonRequired2(input1))
    }

    @Test
    fun calculatePaperRequiredTest() {
        val input1 = listOf("2x3x4")
        val input2 = listOf("1x1x10")

        assertEquals(58, calculatePaperRequired(input1))
        assertEquals(43, calculatePaperRequired(input2))
        assertNotEquals(43, calculatePaperRequired(input1))
    }

    @Test
    fun calculatePaperRequired2Test() {
        val input1 = listOf("2x3x4")
        val input2 = listOf("1x1x10")

        assertEquals(58, calculatePaperRequired2(input1))
        assertEquals(43, calculatePaperRequired2(input2))
        assertNotEquals(43, calculatePaperRequired2(input1))
    }
}