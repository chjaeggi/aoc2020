import chjaeggi.Day1
import org.junit.Test
import kotlin.test.assertEquals

class TestDay1 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            514_579, Day1(
                listOf(
                    1721,
                    979,
                    366,
                    299,
                    675,
                    1456
                )
            ).solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            2_418_61_950, Day1(
                listOf(
                    979,
                    366,
                    675,
                )
            ).solvePart2()
        )
    }
}