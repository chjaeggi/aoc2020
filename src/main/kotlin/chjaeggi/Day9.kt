package chjaeggi

class Day9(private val input: List<Long>, private val preAmble: Int) {

    fun solvePart1(): Long {
        input.forEachIndexed { index, _ ->
            if (index < (preAmble)) {
                return@forEachIndexed
            } else if (index + 1 >= input.size) {
                return@forEachIndexed
            } else {
                val expected = input[index + 1]
                val subList = input.subList(index - (preAmble - 1), index + 1)
                if (!subList.hasSumInTwo(expected)) {
                    return expected
                }
            }
        }
        return -1
    }

    fun solvePart2(): Long {
        return input.hasSumInRange(solvePart1())
    }
}

fun List<Long>.hasSumInTwo(expectedSum: Long): Boolean {
    for (first in this.indices) {
        for (second in this.indices) {
            if (second == first) {
                continue
            }
            if ((this[first] + this[second]) == expectedSum) {
                return true
            }
        }
    }
    return false
}

fun List<Long>.hasSumInRange(expectedSum: Long): Long {

    var first = 0
    var second = 0
    var result = 0L

    fun reset() {
        first++
        second = first
        result = 0L
    }

    while (first < this.size) {
        if (second >= this.size) {
            reset()
            continue
        }
        result += this[second]
        if (result == expectedSum) {
            return (this.subList(first, second).minOrNull() ?: -1) + (this.subList(first, second).maxOrNull() ?: -1)
        }
        if (result > expectedSum) {
            reset()
            continue
        }
        second++
    }
    return -1
}