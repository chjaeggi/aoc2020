package chjaeggi


class Day10(private val input: List<Int>) {

    fun solvePart1(): Int {
        val sortedAdapters = input.sorted()
        var distanceOne = 1
        var distanceThree = 1
        val windows = sortedAdapters.windowed(2, 1, false)
        windows.forEach {
            val diff = it[1] - it[0]
            if (diff == 1) {
                distanceOne++
            }
            if (diff == 3) {
                distanceThree++
            }
        }
        return distanceOne * distanceThree
    }

    fun solvePart2(): Long {
        var lastIndex = 0
        val sublists: MutableList<List<Int>> = mutableListOf()
        var result = 1L

        val sortedAdapters: MutableList<Int> = input.sorted().toMutableList()
        sortedAdapters.add(0, 0)
        sortedAdapters.add(sortedAdapters.lastIndex + 1, sortedAdapters.last() + 3)
        sortedAdapters.forEachIndexed { index, number ->
            if (index + 1 >= sortedAdapters.size) {
                return@forEachIndexed
            }
            if (sortedAdapters[index + 1] == sortedAdapters[index] + 3) {
                sublists.add(sortedAdapters.subList(lastIndex, index + 1))
                lastIndex = index + 1
            }
        }

        // TODO: simplification only works on continuous lists with no gaps in between elements
        sublists.forEach {
            if (it.size == 3) {
                result *= 2L
            }
            if (it.size == 4) {
                result *= 4L
            }
            if (it.size == 5) {
                result *= 7L
            }
        }

        return result
    }
}