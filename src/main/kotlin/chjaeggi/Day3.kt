package chjaeggi

class Day3(private val input: List<String>) {

    private val repeatedMap = input.map {
        it.repeat((input.size / input[0].length) * 10)
    }

    private fun findTrees(x: Int, y: Int): Int {
        var right = 0
        var down = 0
        var result = 0

        while (down < repeatedMap.size - 1) {
            right += x
            down += y
            if (repeatedMap[down][right] == '#') {
                result += 1
            }
        }
        return result
    }

    fun solvePart1(): Int {
        return findTrees(3, 1)
    }

    fun solvePart2(): Int {
        return findTrees(1, 1) * findTrees(3, 1) *
                findTrees(5, 1) * findTrees(7, 1) *
                findTrees(1, 2)
    }
}