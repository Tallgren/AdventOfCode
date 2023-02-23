package AoC2019.D1

import AoC2019.D1.P2.calculateFuelOfModules2
import AoC2019.D1.P2.moduleIterator2
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotEquals
import org.testng.annotations.Test

class FuelCounterTest{

    @Test
    fun moduleIteratorTest() {
        val input1 = listOf("14","1969","100756")

        assertEquals(2+966+50346, moduleIterator(input1))
        assertNotEquals(50346, moduleIterator(input1))
    }

    @Test
    fun moduleIterator2Test() {
        val input1 = listOf("14","1969","100756")

        assertEquals(2+966+50346, moduleIterator2(input1))
        assertNotEquals(50346, moduleIterator2(input1))
    }

    @Test
    fun calculateFuelOfModulesTest() {
        val input1 = 14
        val input2 = 1969
        val input3 = 100756

        assertEquals(2, calculateFuelOfModules(input1))
        assertEquals(966, calculateFuelOfModules(input2))
        assertEquals(50346, calculateFuelOfModules(input3))
        assertNotEquals(50346, calculateFuelOfModules(input1))
    }

    @Test
    fun calculateFuelOfModules2Test() {
        val input1 = 14
        val input2 = 1969
        val input3 = 100756

        assertEquals(2, calculateFuelOfModules2(input1))
        assertEquals(966, calculateFuelOfModules2(input2))
        assertEquals(50346, calculateFuelOfModules2(input3))
        assertNotEquals(50346, calculateFuelOfModules2(input1))
    }
}