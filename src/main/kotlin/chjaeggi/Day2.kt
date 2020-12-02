package chjaeggi

class Day2(private val input: List<String>) {
    private var result = 0

    fun solvePart1(): Int {
        input.forEach {
            var str = it.split("-")
            val low = str[0].toInt()
            str = str[1].split(" ")
            val high = str[0].toInt()
            val password = str[2]
            str = str[1].split(": ")
            val char = str[0].first()
            val number = password.count { it == char }
            if (number in low..high) {
                result += 1
            }
        }
        return result
    }

    fun solvePart2(): Int {
        input.forEach {
            var str = it.split("-")
            val low = str[0].toInt()
            str = str[1].split(" ")
            val high = str[0].toInt()
            val password = str[2]
            str = str[1].split(": ")
            val char = str[0].first()
            val number1 = password.elementAt(low - 1) == char
            val number2 = password.elementAt(high - 1) == char
            if (number1.xor(number2)) {
                result += 1
            }
        }
        return result
    }
}