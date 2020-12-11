import chjaeggi.Day10
import org.junit.Test
import kotlin.test.assertEquals

class TestDay10 {

    private val testList1 = listOf(
        16,
        10,
        15,
        5,
        1,
        11,
        7,
        19,
        6,
        12,
        4,
    )
    private val testList2 = listOf(
        28,
        33,
        18,
        42,
        31,
        14,
        46,
        20,
        48,
        47,
        24,
        23,
        49,
        45,
        19,
        38,
        39,
        11,
        1,
        32,
        25,
        35,
        8,
        17,
        7,
        9,
        4,
        2,
        34,
        10,
        3,
    )

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            35, Day10(
                testList1
            ).solvePart1()
        )
        assertEquals(
            220, Day10(
                testList2
            ).solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            8, Day10(
                testList1
            ).solvePart2()
        )
        assertEquals(
            19208, Day10(
                testList2
            ).solvePart2()
        )
    }
}