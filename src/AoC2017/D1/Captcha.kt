package AoC2017.D1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Arrays

fun captcha() {
    val input = readLines()
    println(Arrays.toString(input))
    val result = captchaSolver(input)
    println(result)
}

fun captchaSolver(input: IntArray): Int {
    var sum = 0
    for (element in input) {
        if (input.indexOf(element) == input.indexOf(input.last())) {
            if (input.last() == input.first()) {
                sum += element
            }
        } else {
            if (element == input[input.indexOf(input.indexOf(element + 1))]) {
                sum += element
            }
        }
        println(sum)
    }
    return sum
}

fun readLines(): IntArray{
    val fileName = "C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2017\\D1\\input.txt"
    return try {
        Files.readString(Paths.get(fileName)).map { c -> Integer.parseInt(c.toString()) }.toIntArray()
    } catch (e: IOException) {
        e.printStackTrace()
        return intArrayOf()
    }
}

fun main() {
    captcha()
}