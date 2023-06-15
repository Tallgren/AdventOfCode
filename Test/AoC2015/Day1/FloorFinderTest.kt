package AoC2015.Day1
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotEquals
import org.testng.annotations.Test

class FloorFinderTest {

    @Test
    fun findFloorTest() {
        val input1 = "(())".toCharArray()
        val input2 = "(((".toCharArray()
        val input3 = "))(((((".toCharArray()
        val input4 = "())".toCharArray()
        val input5 = ")())())".toCharArray()

        assertEquals(0, findFloor(input1))
        assertEquals(3, findFloor(input2))
        assertEquals(3, findFloor(input3))
        assertEquals(-1, findFloor(input4))
        assertEquals(-3, findFloor(input5))
        assertNotEquals(-3, findFloor(input1))
    }

    @Test
    fun findFloor2Test() {
        val input1 = "(())".toCharArray()
        val input2 = "(((".toCharArray()
        val input3 = "))(((((".toCharArray()
        val input4 = "())".toCharArray()
        val input5 = ")())())".toCharArray()

        assertEquals(0, findFloor2(input1))
        assertEquals(3, findFloor2(input2))
        assertEquals(3, findFloor2(input3))
        assertEquals(-1, findFloor2(input4))
        assertEquals(-3, findFloor2(input5))
        assertNotEquals(-3, findFloor2(input1))
    }

    @Test
    fun findPosBasementTest() {
        val input1 = ")".toCharArray()
        val input2 = "()())".toCharArray()

        assertEquals(1, findPosBasement(input1))
        assertEquals(5, findPosBasement(input2))
        assertNotEquals(5, findPosBasement(input1))
    }

    @Test
    fun findPosBasement2Test() {
        val input1 = ")".toCharArray()
        val input2 = "()())".toCharArray()

        assertEquals(1, findPosBasement2(input1))
        assertEquals(5, findPosBasement2(input2))
        assertNotEquals(5, findPosBasement2(input1))
    }
}