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
        @Test
        fun `can rotate top slice 90 degrees anticlockwise`() {
            assertThat(testCube.rotateTopSlice90DegreesAntiClockwise().faces).isEqualTo(listOf(
                "CFIBEHADG", // top
                "jklMNOPQR", // front
                "JKLVWXYZ!", // right
                "STUdefghi", // back
                "abcmnopqr", // left
                "stuvwxyz?"  // bottom
            ))
        }

        @Test
        fun `can rotate top slice 180 degrees`() {
            assertThat(testCube.rotateTopSlice180Degrees().faces).isEqualTo(listOf(
                "IHGFEDCBA", // top
                "abcMNOPQR", // front
                "jklVWXYZ!", // right
                "JKLdefghi", // back
                "STUmnopqr", // left
                "stuvwxyz?"  // bottom
            ))
        }

        @Test
        fun `can rotate top slice 90 degrees clockwise`() {
            assertThat(testCube.rotateTopSlice90DegreesClockwise().faces).isEqualTo(listOf(
                "GDAHEBIFC", // top
                "STUMNOPQR", // front
                "abcVWXYZ!", // right
                "jkldefghi", // back
                "JKLmnopqr", // left
                "stuvwxyz?"  // bottom
            ))
        }
    }
}