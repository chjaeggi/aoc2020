import chjaeggi.Day5
import org.junit.Test
import kotlin.test.assertEquals

class TestDay5 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            357, Day5(
                listOf(
                    "FBFBBFFRLR"
                )
            ).solvePart1()
        )
        assertEquals(
            567, Day5(
                listOf(
                    "BFFFBBFRRR"
                )
            ).solvePart1()
        )
        assertEquals(
            119, Day5(
                listOf(
                    "FFFBBBFRRR"
                )
            ).solvePart1()
        )
        assertEquals(
            820, Day5(
                listOf(
                    "BBFFBBFRLL"
                )
            ).solvePart1()
        )
    }
}