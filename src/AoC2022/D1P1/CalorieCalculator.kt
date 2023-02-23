package AoC2022.D1P1
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

var sum: Int = 0
var highest: Int = 0

/*class CalorieCalculator {

    var calorieList = readLines()
}

 */

fun readLines(): List<String> {
    val fileName = "C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\Kotlin\\AoC2022.D1P1\\input.txt"
    try {
        val lines = Files.readAllLines(Paths.get(fileName))
        return lines
    } catch (e: IOException) {
        e.printStackTrace()
        return emptyList()
    }
}

fun main() {
    //CalorieCalculator()
    println(sum)
}