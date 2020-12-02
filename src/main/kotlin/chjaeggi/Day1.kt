package chjaeggi

class Day1(private val input: List<Int>) {

    private val desiredValue = 2020
    private var second = -1
    private var third = -1
    private var result = -1

    fun solvePart1(): Int {
        input.forEachIndexed { idx, it ->
            val first = it
            second = input.drop(idx).find {
                (desiredValue - first == it)
            } ?: -1
            if (second != -1) {
                result = first * second
                return@forEachIndexed
            }
        }
        return result
    }

    fun solvePart2(): Int {
        var first: Int
        var second: Int
        input.forEachIndexed for1@{ idx, it ->
            first = it
            input.drop(idx).forEachIndexed { idx, it ->
                second = it
                third = input.drop(idx).find {
                    (desiredValue - first - second == it)
                } ?: -1
                if (third != -1) {
                    result = first * second * third
                    return@for1
                }
            }
        }
        return result
    }
}