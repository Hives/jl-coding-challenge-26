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
    @DisplayName("Rotating the top slice")
    inner class RotatingTheTopSlice {

        @Nested
        @DisplayName("Anti-clockwise")
        inner class AntiClockwise {

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

            @Test
            fun `can rotate top slice four quarter-turns anti clockwise`() {
                assertThat(testCube.rotateTopSlice(4)).isEqualTo(testCube)
            }
        }

        @Nested
        @DisplayName("Clockwise")
        inner class Clockwise {

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

            @Test
            fun `can rotate top slice four quarter-turns clockwise`() {
                assertThat(testCube.rotateTopSlice(-4)).isEqualTo(testCube)
            }
        }
    }

    @Nested
    @DisplayName("Rotating the cube")
    inner class RotatingTheCube {

        @Nested
        @DisplayName("About the X Axis")
        inner class AboutTheXAxis {
            @Test
            fun `can rotate the cube one quarter-turn anti-clockwise about the x axis`() {
                assertThat(testCube.rotateX(1).faces).isEqualTo(
                    listOf(
                        "ihgfedcba", // top
                        "ABCDEFGHI", // front
                        "UX!TWZSVY", // right
                        "?zyxwvuts", // back
                        "pmjqnkrol", // leftx
                        "JKLMNOPQR"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube two quarter-turns anti-clockwise about the x axis`() {
                assertThat(testCube.rotateX(2).faces).isEqualTo(
                    listOf(
                        "stuvwxyz?", // top
                        "ihgfedcba", // front
                        "!ZYXWVUTS", // right
                        "RQPONMLKJ", // back
                        "rqponmlkj", // left
                        "ABCDEFGHI"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube one quarter-turn clockwise about the x axis`() {
                assertThat(testCube.rotateX(-1).faces).isEqualTo(
                    listOf(
                        "JKLMNOPQR", // top
                        "stuvwxyz?", // front
                        "YVSZWT!XU", // right
                        "IHGFEDCBA", // back
                        "lorknqjmp", // left
                        "ihgfedcba"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube four quarter-turns clockwise about the x axis`() {
                assertThat(testCube.rotateX(-4)).isEqualTo(testCube)
            }
        }

        @Nested
        @DisplayName("About the Y Axis")
        inner class AboutTheYAxis {
            @Test
            fun `can rotate the cube one quarter-turn anti-clockwise about the Y axis`() {
                assertThat(testCube.rotateY(1).faces).isEqualTo(
                    listOf(
                        "CFIBEHADG", // top
                        "jklmnopqr", // front
                        "JKLMNOPQR", // right
                        "STUVWXYZ!", // back
                        "abcdefghi", // left
                        "yvszwt?xu"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube two quarter-turns anti-clockwise about the Y axis`() {
                assertThat(testCube.rotateY(2).faces).isEqualTo(
                    listOf(
                        "IHGFEDCBA", // top
                        "abcdefghi", // front
                        "jklmnopqr", // right
                        "JKLMNOPQR", // back
                        "STUVWXYZ!", // left
                        "?zyxwvuts"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube three quarter-turns anti-clockwise about the Y axis`() {
                assertThat(testCube.rotateY(3).faces).isEqualTo(
                    listOf(
                        "GDAHEBIFC", // top
                        "STUVWXYZ!", // front
                        "abcdefghi", // right
                        "jklmnopqr", // back
                        "JKLMNOPQR", // left
                        "ux?twzsvy"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube one quarter-turn clockwise about the Y axis`() {
                assertThat(testCube.rotateY(-1).faces).isEqualTo(
                    listOf(
                        "GDAHEBIFC", // top
                        "STUVWXYZ!", // front
                        "abcdefghi", // right
                        "jklmnopqr", // back
                        "JKLMNOPQR", // left
                        "ux?twzsvy"  // bottom
                    )
                )
            }

            @Test
            fun `can rotate the cube four quarter-turns clockwise about the Y axis`() {
                assertThat(testCube.rotateY(-4)).isEqualTo(testCube)
            }
        }
    }
}