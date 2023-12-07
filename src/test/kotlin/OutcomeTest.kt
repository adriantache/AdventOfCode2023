import aoc23.Outcome
import aoc23.Outcome.Companion.compareStrings
import aoc23.Outcome.Companion.toCardRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutcomeTest {
    @Test
    fun toCardRank() {
        val input = "AKQJT98765432"
        val expected = listOf(15, 14, 13, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2)

        input.forEachIndexed { i, c ->
            assertThat(c.toCardRank()).isEqualTo(expected[i])
        }
    }

    @Test
    fun compareStrings() {
        val input = "AKQJT"
        val other = "AKQJ9"

        assertThat(compareStrings(input, other)).isEqualTo(1)
        assertThat(compareStrings(other, input)).isEqualTo(-1)

        val input2 = "AAAAA"
        val other2 = "AAAAA"
        assertThat(compareStrings(input2, other2)).isEqualTo(0)

        val input3 = "A2345"
        val other3 = "23456"
        assertThat(compareStrings(input3, other3)).isEqualTo(13)

        val input4 = "11411"
        val other4 = "11511"
        assertThat(compareStrings(input4, other4)).isEqualTo(-1)
        assertThat(compareStrings(other4, input4)).isEqualTo(1)
    }

    @Test
    fun `outcome, from string`() {
        val input = "AAAAA"
        val result = Outcome.fromString(input)
        assertThat(result).isInstanceOf(Outcome.Five::class.java)
        val resultCast = result as Outcome.Five
        assertThat(resultCast.string).isEqualTo(input)
        assertThat(resultCast.cardRank).isEqualTo(15)

        val input2 = "JJAJJ"
        val result2 = Outcome.fromString(input2)
        assertThat(result2).isInstanceOf(Outcome.Four::class.java)
        val resultCast2 = result2 as Outcome.Four
        assertThat(resultCast2.string).isEqualTo(input2)
        assertThat(resultCast2.cardRank).isEqualTo(12)

        val input3 = "T3T33"
        val result3 = Outcome.fromString(input3)
        assertThat(result3).isInstanceOf(Outcome.Full::class.java)
        val resultCast3 = result3 as Outcome.Full
        assertThat(resultCast3.string).isEqualTo(input3)
        assertThat(resultCast3.majorCardRank).isEqualTo(3)
        assertThat(resultCast3.minorCardRank).isEqualTo(10)

        val input4 = "T4A44"
        val result4 = Outcome.fromString(input4)
        assertThat(result4).isInstanceOf(Outcome.Three::class.java)
        val resultCast4 = result4 as Outcome.Three
        assertThat(resultCast4.string).isEqualTo(input4)
        assertThat(resultCast4.cardRank).isEqualTo(4)

        val input5 = "T5AT5"
        val result5 = Outcome.fromString(input5)
        assertThat(result5).isInstanceOf(Outcome.Two::class.java)
        val resultCast5 = result5 as Outcome.Two
        assertThat(resultCast5.string).isEqualTo(input5)
        assertThat(resultCast5.majorCardRank).isEqualTo(10)
        assertThat(resultCast5.minorCardRank).isEqualTo(5)

        val input6 = "96AT6"
        val result6 = Outcome.fromString(input6)
        assertThat(result6).isInstanceOf(Outcome.One::class.java)
        val resultCast6 = result6 as Outcome.One
        assertThat(resultCast6.string).isEqualTo(input6)
        assertThat(resultCast6.cardRank).isEqualTo(6)

        val input7 = "32475"
        val result7 = Outcome.fromString(input7)
        assertThat(result7).isInstanceOf(Outcome.High::class.java)
        val resultCast7 = result7 as Outcome.High
        assertThat(resultCast7.string).isEqualTo(input7)
        assertThat(resultCast7.cardRank).isEqualTo(7)
    }
}