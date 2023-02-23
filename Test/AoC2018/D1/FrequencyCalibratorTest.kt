package AoC2018.D1

import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotEquals
import org.testng.annotations.Test

class FrequencyCalibratorTest {

    @Test
    fun calibrateTest() {
        val input1 = listOf("+1", "-2", "+3", "+1")
        val input2 = listOf("+1", "+1", "+1")
        val input3 = listOf("+1", "+1", "-2")
        val input4 = listOf("-1", "-2", "-3")

        assertEquals(3, calibrate(input1))
        assertEquals(3, calibrate(input2))
        assertEquals(0, calibrate(input3))
        assertEquals(-6, calibrate(input4))
        assertNotEquals(-6, calibrate(input1))
    }

    @Test
    fun calibrate2Test() {
        val input1 = listOf("+1", "-2", "+3", "+1")
        val input2 = listOf("+1", "+1", "+1")
        val input3 = listOf("+1", "+1", "-2")
        val input4 = listOf("-1", "-2", "-3")

        assertEquals(3, calibrate2(input1))
        assertEquals(3, calibrate2(input2))
        assertEquals(0, calibrate2(input3))
        assertEquals(-6, calibrate2(input4))
        assertNotEquals(-6, calibrate2(input1))
    }

    @Test
    fun findFirstFrequencyReachedTwiceTest() {
        val input1 = listOf("+1", "-1")
        val input2 = listOf("+3", "+3", "+4", "-2", "-4")
        val input3 = listOf("-6", "+3", "+8", "+5", "-6")
        val input4 = listOf("+7", "+7", "-2", "-7", "-4")

        assertEquals(0, findFirstFrequencyReachedTwice(input1))
        assertEquals(10, findFirstFrequencyReachedTwice(input2))
        assertEquals(5, findFirstFrequencyReachedTwice(input3))
        assertEquals(14, findFirstFrequencyReachedTwice(input4))
        assertNotEquals(-6, findFirstFrequencyReachedTwice(input1))
    }

    @Test
    fun findFirstFrequencyReachedTwice2Test() {
        val input1 = listOf("+1", "-1")
        val input2 = listOf("+3", "+3", "+4", "-2", "-4")
        val input3 = listOf("-6", "+3", "+8", "+5", "-6")
        val input4 = listOf("+7", "+7", "-2", "-7", "-4")

        assertEquals(0, findFirstFrequencyReachedTwice2(input1))
        assertEquals(10, findFirstFrequencyReachedTwice2(input2))
        assertEquals(5, findFirstFrequencyReachedTwice2(input3))
        assertEquals(14, findFirstFrequencyReachedTwice2(input4))
        assertNotEquals(-6, findFirstFrequencyReachedTwice2(input1))
    }

}