import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CubeTest {
    private val testCube = Cube(
        listOf(
            "ABCDEFGHI", // top
            "JKLMNOPQR", // front
            "STUVWXYZ!", // right
            "abcdefghi", // back
            "jklmnopqr", // left
            "stuvwxyz?"  // bottom
        )
    )

    @Nested
    @DisplayName("Rotating the top slice anti-clockwise")
    inner class RotatingTheTopSliceAntiClockwise {
        @Test
        fun `can rotate top slice one quarter-turn anti-clockwise`() {
            assertThat(testCube.rotateTopSlice(1).faces).isEqualTo(
                listOf(
                    "CFIBEHADG", // top
                    "jklMNOPQR", // front
                    "JKLVWXYZ!", // right
                    "STUdefghi", // back
                    "abcmnopqr", // left
                    "stuvwxyz?"  // bottom
                )
            )
        }

        @Test
        fun `can rotate top slice two quarter-turns anti-clockwise`() {
            assertThat(testCube.rotateTopSlice(2).faces).isEqualTo(
                listOf(
                    "IHGFEDCBA", // top
                    "abcMNOPQR", // front
                    "jklVWXYZ!", // right
                    "JKLdefghi", // back
                    "STUmnopqr", // left
                    "stuvwxyz?"  // bottom
                )
            )
        }

        @Test
        fun `can rotate top slice three quarter-turns anti clockwise`() {
            assertThat(testCube.rotateTopSlice(3).faces).isEqualTo(
                listOf(
                    "GDAHEBIFC", // top
                    "STUMNOPQR", // front
                    "abcVWXYZ!", // right
                    "jkldefghi", // back
                    "JKLmnopqr", // left
                    "stuvwxyz?"  // bottom
                )
            )
        }
    }

    @Nested
    @DisplayName("Rotating the top slice clockwise")
    inner class RotatingTheTopSliceClockwise {
        @Test
        fun `can rotate top slice one quarter-turn clockwise`() {
            assertThat(testCube.rotateTopSlice(-1).faces).isEqualTo(
                listOf(
                    "GDAHEBIFC", // top
                    "STUMNOPQR", // front
                    "abcVWXYZ!", // right
                    "jkldefghi", // back
                    "JKLmnopqr", // left
                    "stuvwxyz?"  // bottom
                )
            )
        }

        @Test
        fun `can rotate top slice two quarter-turns clockwise`() {
            assertThat(testCube.rotateTopSlice(-2).faces).isEqualTo(
                listOf(
                    "IHGFEDCBA", // top
                    "abcMNOPQR", // front
                    "jklVWXYZ!", // right
                    "JKLdefghi", // back
                    "STUmnopqr", // left
                    "stuvwxyz?"  // bottom
                )
            )
        }

        @Test
        fun `can rotate top slice three quarter-turns clockwise`() {
            assertThat(testCube.rotateTopSlice(-3).faces).isEqualTo(
                listOf(
                    "CFIBEHADG", // top
                    "jklMNOPQR", // front
                    "JKLVWXYZ!", // right
                    "STUdefghi", // back
                    "abcmnopqr", // left
                    "stuvwxyz?"  // bottom
                )
            )
        }
    }

}