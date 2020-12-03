import chjaeggi.Day2
import chjaeggi.Day3
import org.junit.Test
import kotlin.test.assertEquals

class TestDay3 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            7, Day3(
                listOf(
                    "..##.......",
                    "#...#...#..",
                    ".#....#..#.",
                    "..#.#...#.#",
                    ".#...##..#.",
                    "..#.##.....",
                    ".#.#.#....#",
                    ".#........#",
                    "#.##...#...",
                    "#...##....#",
                    ".#..#...#.#",
                )
            ).solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            336, Day3(
                listOf(
                    "..##.......",
                    "#...#...#..",
                    ".#....#..#.",
                    "..#.#...#.#",
                    ".#...##..#.",
                    "..#.##.....",
                    ".#.#.#....#",
                    ".#........#",
                    "#.##...#...",
                    "#...##....#",
                    ".#..#...#.#",
                )
            ).solvePart2()
        )
    }
}