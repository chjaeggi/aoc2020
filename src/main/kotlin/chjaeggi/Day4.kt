package chjaeggi


class Day4(input: List<String>) {

    private val passportData: MutableList<String> = mutableListOf()
    private var valid = 0

    init {
        var temporaryPassport = ""
        input.forEach {
            if (it != "") {
                temporaryPassport += it
                temporaryPassport += " "
            } else {
                passportData.add(temporaryPassport.dropLast(1))
                temporaryPassport = ""
            }
        }
        passportData.add(temporaryPassport.dropLast(1)) // write last element as input has no newline end
    }

    fun solvePart1(): Int {
        passportData.forEach {
            val passportFields = it.split(" ")
            if (passportFields.size == 8) {
                valid += 1
            } else if (passportFields.size == 7 && "cid" !in it) {
                valid += 1
            }
        }
        return valid

    }

    private fun checkValidity(line: String): Boolean {
        val passport = line.replace(" ", "")
            .split(",")

        val p = passport.toString()
        if (!("pid" in p && "hgt" in p && "ecl" in p && "iyr" in p && "eyr" in p && "byr" in p && "hcl" in p)) {
            return false
        }

        passport.forEach {
            val key = it.split(":")[0]
            val value = it.split(":")[1]
            when (key) {
                "byr" -> if (value.toInt() !in 1920..2002) {
                    return false
                }
                "iyr" -> if (value.toInt() !in 2010..2020) {
                    return false
                }
                "eyr" -> if (value.toInt() !in 2020..2030) {
                    return false
                }
                "hgt" -> if (value.endsWith("cm")) {
                    if (value.dropLast(2).toInt() !in 150..193) {
                        return false
                    }
                } else if (value.endsWith("in")) {
                    if (value.dropLast(2).toInt() !in 59..76) {
                        return false
                    }
                } else {
                    return false
                }
                "hcl" -> if (!(value.matches("^#[a-f|0-9]{6}$".toRegex()))) {
                    return false
                }
                "ecl" -> if (!(value.matches("^amb$|^blu$|^brn$|^gry$|^grn$|^hzl$|^oth$".toRegex()))) {
                    return false
                }
                "pid" -> if (!(value.matches("^[0-9]{9}$".toRegex()))) {
                    return false
                }
            }
        }
        return true
    }

    fun solvePart2(): Int {
        passportData.forEach {
            val passportFields = it.split(" ")
            if (checkValidity(passportFields.toString().drop(1).dropLast(1))) {
                valid += 1
            }
        }
        return valid
    }
}