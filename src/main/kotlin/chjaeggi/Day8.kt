package chjaeggi

enum class ComputerStatus {
    OK, INF_LOOP, FAIL
}

class Day8(private val input: List<String>) {

    private var accumulator = 0

    fun solvePart1(): Int {
        pocketComputer(input)
        return accumulator
    }

    fun solvePart2(): Int {
        val nopJmpList = mutableListOf<Int>()
        input.forEachIndexed { idx, item ->
            if (item.contains("nop") || item.contains("jmp")) {
                nopJmpList += idx
            }
        }
        nopJmpList.forEach {
            val code = mutableListOf<String>().apply { addAll(input) }
            if (input[it].contains("jmp")) {
                code[it] = code[it].replace("jmp", "nop")
            } else {
                code[it] = code[it].replace("nop", "jmp")
            }

            if (pocketComputer(code) == ComputerStatus.OK) {
                return accumulator
            }
        }
        return -1
    }

    private fun pocketComputer(code: List<String>): ComputerStatus {

        // reset computer
        val executed = mutableListOf<Int>()
        var instructionPointer = 0
        accumulator = 0

        while (instructionPointer !in executed && instructionPointer < code.size) {
            val operation = code[instructionPointer].substringBefore(" ")
            val parameter = code[instructionPointer].substringAfter(" ")
            executed.add(instructionPointer)

            when (operation) {
                "acc" -> {
                    accumulator += parameter.toInt()
                    instructionPointer++
                }
                "nop" -> {
                    instructionPointer++
                }
                "jmp" -> {
                    instructionPointer += parameter.toInt()
                }
            }
        }

        return when (instructionPointer) {
            code.size -> {
                ComputerStatus.OK
            }
            in executed -> {
                ComputerStatus.INF_LOOP
            }
            else -> {
                ComputerStatus.FAIL
            }
        }
    }

}