import chjaeggi.Day1
import chjaeggi.Day2
import org.junit.Test
import kotlin.test.assertEquals

class TestDay2 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            2, Day2(
                listOf(
                    "1-3 a: abcde",
                    "1-3 b: cdefg",
                    "2-9 c: ccccccccc",
                )
            ).solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            1, Day2(
                listOf(
                    "1-3 a: abcde",
                    "1-3 b: cdefg",
                    "2-9 c: ccccccccc",
                )
            ).solvePart2()
        )
    }
}