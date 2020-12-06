import chjaeggi.Day6
import org.junit.Test
import kotlin.test.assertEquals

class TestDay6 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            11, Day6("abc\n" +
                    "\n" +
                    "a\n" +
                    "b\n" +
                    "c\n" +
                    "\n" +
                    "ab\n" +
                    "ac\n" +
                    "\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "\n" +
                    "b").solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            6, Day6("abc\n" +
                    "\n" +
                    "a\n" +
                    "b\n" +
                    "c\n" +
                    "\n" +
                    "ab\n" +
                    "ac\n" +
                    "\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "\n" +
                    "b").solvePart2()
        )
    }
}