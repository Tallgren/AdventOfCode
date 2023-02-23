package AoC2018.D2

import java.io.IOException
import java.lang.StringBuilder
import java.nio.file.Files
import java.nio.file.Paths

fun inventoryManagementSystem2() {
    //part 1
    val input = readLines2()
    val result = calculateChecksum2(input)
    println(result)

    //part 2
    val result2 = findStringsDifferingOneLetter2(input)
    println(result2)
}

fun calculateChecksum2(inputList: List<String>): Int {
    var sumDoubles = 0
    var sumTriples = 0

    for(element in inputList) {
        //skapar en map där nycklarna är characters och values är en lista av characters med samma value
        val characters = element.groupBy { it }
        //om listan är 2 så finns det 2 av den charen "[a,a].size == 2"
        if (characters.any{it.value.size == 2}) sumDoubles++
        if (characters.any{it.value.size == 3}) sumTriples++
    }
    return sumDoubles*sumTriples
}

fun findStringsDifferingOneLetter2(inputList: List<String>): String {
    //man kan skriva såhär
    for (i in inputList[0].indices) {
        val seen = mutableSetOf<String>()
        for (s in inputList) {
            //tar bort char på pos i
            val temp = s.removeRange(i, i+1)
            if (seen.contains(temp)) {
                return temp
            }
            seen.add(temp)
        }
    }
    return ""
}


fun readLines2(): List<String> {
    val fileName = "C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2018\\D2\\input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    inventoryManagementSystem2()
}
