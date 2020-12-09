package chjaeggi

fun main(args: Array<String>) {
    val day = Day9(Resources.resourceAsListOfLong("input9.txt"), 25).solvePart2()
    println("Done: $day")
}