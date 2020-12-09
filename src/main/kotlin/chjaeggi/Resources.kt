package chjaeggi

import java.io.File
import java.math.BigInteger
import java.net.URI

internal object Resources {
    fun resourceAsString(fileName: String, delimiter: String = ""): String =
        resourceAsList(fileName).reduce { a, b -> "$a$delimiter$b" }

    fun resourceAsList(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun resourceAsListOfInt(fileName: String): List<Int> =
        resourceAsList(fileName).map { it.toInt() }

    fun resourceAsListOfLong(fileName: String): List<Long> =
        resourceAsList(fileName).map { it.toLong() }

    fun resourceAsListOfBigInt(fileName: String): List<BigInteger> =
        resourceAsList(fileName).map { it.toBigInteger() }

    fun resourceAsText(fileName: String): String =
        File(fileName.toURI()).readText()

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find Resource: $this")
}
