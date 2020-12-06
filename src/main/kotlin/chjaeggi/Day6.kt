package chjaeggi

class Day6(input: String) {

    private val answers: List<String> = input.split("\n\n")
    private var count = 0

    fun solvePart1(): Int {
        answers.forEach {
            count += it.replace("\n", "").toCharArray().toSet().count()
        }
        return count
    }


    fun solvePart2(): Int {
        answers.forEach {
            val groupSize = it.count { it == '\n' } + 1
            val answersPerGroup = it.replace("\n", "").toCharArray()

            var char = 'a'
            while (char <= 'z') {
                if (answersPerGroup.count { it == char } == groupSize) {
                    count += 1
                }
                char++
            }
        }
        return count
    }
}