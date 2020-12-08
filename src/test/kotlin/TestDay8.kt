import chjaeggi.Day8
import org.junit.Test
import kotlin.test.assertEquals

class TestDay8 {

    @Test
    fun `Assert correct output part1`() {
        assertEquals(
            5, Day8(
                listOf(
                    "nop +0",
                    "acc +1",
                    "jmp +4",
                    "acc +3",
                    "jmp -3",
                    "acc -99",
                    "acc +1",
                    "jmp -4",
                    "acc +6",
                )
            ).solvePart1()
        )
    }

    @Test
    fun `Assert correct output part2`() {
        assertEquals(
            8, Day8(
                listOf(
                    "nop +0",
                    "acc +1",
                    "jmp +4",
                    "acc +3",
                    "jmp -3",
                    "acc -99",
                    "acc +1",
                    "jmp -4",
                    "acc +6",
                )
            ).solvePart2()
        )
    }
}