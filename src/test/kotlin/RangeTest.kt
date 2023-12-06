import aoc23.Range
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RangeTest {
    @Test
    fun convertRange() {
        val inputRange = 1L..10L
        val outputRange = 11L..20

        inputRange.forEach {
            val result = Range(
                inputRange = inputRange,
                outputRange = outputRange,
            ).convert(it)

            assertThat(result).isEqualTo(it + 10)
        }
    }
}