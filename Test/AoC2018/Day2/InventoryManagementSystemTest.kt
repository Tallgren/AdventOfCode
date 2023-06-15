package AoC2018.Day2

import org.testng.Assert
import org.testng.annotations.Test

class InventoryManagementSystemTest {

    @Test
    fun calculateChecksumTest() {
        val input1 = listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")

        Assert.assertEquals(12, calculateChecksum(input1))
        Assert.assertNotEquals(-6, calculateChecksum(input1))
    }

    @Test
    fun calculateChecksum2Test() {
        val input1 = listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")

        Assert.assertEquals(12, calculateChecksum2(input1))
        Assert.assertNotEquals(-6, calculateChecksum2(input1))
    }

    @Test
    fun findStringsDifferingOneLetterTest() {
        val input1 = listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")

        Assert.assertEquals("fgij", findStringsDifferingOneLetter(input1))
        Assert.assertNotEquals("abcde", findStringsDifferingOneLetter(input1))
    }

    @Test
    fun findStringsDifferingOneLetter2Test() {
        val input1 = listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")

        Assert.assertEquals("fgij", findStringsDifferingOneLetter2(input1))
        Assert.assertNotEquals("abcde", findStringsDifferingOneLetter2(input1))
    }
}