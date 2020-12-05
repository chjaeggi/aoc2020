package chjaeggi

import kotlin.math.pow


class Day5(private var input: List<String>) {

    private var seatIds: List<Int> = mutableListOf()

    fun solvePart1(): Int {
        return getFlightSeating().maxOf { it }
    }

    private fun getFlightSeating(): List<Int> {
        input.forEach {
            var row = 0.0
            var col = 0.0
            it.toCharArray().forEachIndexed { idx, c ->
                if (c == 'B') {
                    val power = 6 - idx
                    row += 2.0.pow(power)
                }
                if (c == 'R') {
                    val power = 2 - (idx - 7)
                    col += 2.0.pow(power)
                }
            }
            seatIds += (row * 8 + col).toInt()
        }
        return seatIds
    }

    fun solvePart2(): Int {
        val sortedIds = getFlightSeating().sorted()
        sortedIds.forEachIndexed { index, value ->
            if (sortedIds[index + 1] != value + 1) {
                return value + 1
            }
        }
        return -1
    }
}