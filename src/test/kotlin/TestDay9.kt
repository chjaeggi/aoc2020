import chjaeggi.Day9
import org.junit.Test
import kotlin.test.assertEquals

class TestDay9 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            127, Day9(
                listOf(
                    35,
                    20,
                    15,
                    25,
                    47,
                    40,
                    62,
                    55,
                    65,
                    95,
                    102,
                    117,
                    150,
                    182,
                    127,
                    219,
                    299,
                    277,
                    309,
                    576,
                ), 5
            ).solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            62, Day9(
                listOf(
                    35,
                    20,
                    15,
                    25,
                    47,
                    40,
                    62,
                    55,
                    65,
                    95,
                    102,
                    117,
                    150,
                    182,
                    127,
                    219,
                    299,
                    277,
                    309,
                    576,
                ), 5
            ).solvePart2()
        )
    }
}