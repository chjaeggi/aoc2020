package chjaeggi


class Day7(private val input: List<String>) {

    private val parentsPerBag: MutableMap<String, List<String>> = mutableMapOf()
    private val childrenPerBag: MutableMap<String, MutableMap<String, Int>> = mutableMapOf()

    init {
        input.forEach {
            val splitted = it.split("contain")
            val key = splitted[0].replace(" bags", "").dropLast(1)
            Regex("[a-z]+ [a-z]+,|[a-z]+ [a-z]+.").findAll(splitted[1])
                .forEach {
                    val value = it.value.dropLast(1)
                    if (parentsPerBag.containsKey(value)) {
                        parentsPerBag[value] = parentsPerBag[value]!! + key
                    } else {
                        parentsPerBag[value] = listOf(key)
                    }
                }
            Regex("[0-9]+ [a-z]+ [a-z]+,|[0-9]+ [a-z]+ [a-z]+.|no other ").findAll(splitted[1])
                .forEach {
                    val valueString = it.value.dropLast(1)
                    if (valueString.contains("no other")) {
                        return@forEach
                    }
                    val amount = valueString.substringBefore(" ").toInt()
                    val value = valueString.dropWhile { !it.isLetter() }
                    if (!childrenPerBag.containsKey(key)) {
                        childrenPerBag[key] = mutableMapOf()
                    }
                    childrenPerBag[key]!![value] = amount
                }
        }
    }

    fun solvePart1(): Int {
        return parentsPerBag["shiny gold"]?.flatMap { getParents(it) }?.toSet()?.count() ?: -1
    }

    fun solvePart2(): Int {
        return getCosts("shiny gold", 1)
    }

    private fun getParents(bag: String): List<String> {
        return when (parentsPerBag.containsKey(bag)) {
            false -> listOf(bag)
            true -> listOf(bag) + parentsPerBag[bag]!!.flatMap { getParents(it) }
        }
    }

    private fun getCosts(bag: String, amount: Int): Int {
        return amount * getSameLevelChildrenCost(bag) +
                (getNextLevelChildren(bag)?.map {
                    amount * getCosts(it.key, it.value)
                }?.sum() ?: 0)
    }

    private fun getNextLevelChildren(bag: String): Map<String, Int>? {
        return childrenPerBag[bag]
    }

    private fun getSameLevelChildrenCost(bag: String): Int {
        return childrenPerBag[bag]?.values?.sum() ?: 0
    }
}