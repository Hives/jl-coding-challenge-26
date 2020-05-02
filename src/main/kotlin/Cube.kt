data class Cube(val faces: List<String>) {
    fun rotateTopSlice(n: Int) = repeatedlyApply(Math.floorMod(n, 4)) {
            it.antiClockwiseQuarterTurnOfTopSlice()
        }

    fun rotateY(n: Int) = repeatedlyApply(Math.floorMod(n, 4)) {
        it.antiClockwiseQuarterTurnAboutYAxis()
    }

    private fun antiClockwiseQuarterTurnOfTopSlice() = Cube(
        listOf(
            this.faces[0].rotateFaceAntiClockwise(),
            this.faces[4].substring(0..2) + this.faces[1].substring(3..8),
            this.faces[1].substring(0..2) + this.faces[2].substring(3..8),
            this.faces[2].substring(0..2) + this.faces[3].substring(3..8),
            this.faces[3].substring(0..2) + this.faces[4].substring(3..8),
            this.faces[5]
        )
    )

    private fun antiClockwiseQuarterTurnAboutYAxis() = Cube(
        listOf(
            this.faces[0].rotateFaceAntiClockwise(),
            this.faces[4],
            this.faces[1],
            this.faces[2],
            this.faces[3],
            this.faces[5].rotateFaceClockwise()
        )
    )
}

private tailrec fun <T> T.repeatedlyApply(n: Int, action: (T) -> T): T {
    if (n < 0) throw Exception("number of applications must be positive")
    return if (n == 0) {
        this
    } else {
        action(this).repeatedlyApply(n - 1, action)
    }
}

private fun String.rotateFaceAntiClockwise(): String =
    "${this[2]}${this[5]}${this[8]}${this[1]}${this[4]}${this[7]}${this[0]}${this[3]}${this[6]}"

private fun String.rotateFaceClockwise(): String =
    this.repeatedlyApply(3) { it.rotateFaceAntiClockwise() }