import Face.*

data class Cube(val faces: List<String>) {
    fun rotateSlice(face: Face, times: Int) = when (face) {
        is TOP -> rotateTopSlice(times)
        is BOTTOM -> rotateX(2).rotateTopSlice(times).rotateX(2)
        is RIGHT -> rotateZ(1).rotateTopSlice(times).rotateZ(-1)
        is LEFT -> rotateZ(-1).rotateTopSlice(times).rotateZ(1)
        is FRONT -> rotateX(-1).rotateTopSlice(times).rotateX(1)
    }

    fun rotateX(times: Int) = repeatedlyApply(Math.floorMod(times, 4)) {
        it.antiClockwiseQuarterTurnAboutXAxis()
    }

    fun rotateY(times: Int) = repeatedlyApply(Math.floorMod(times, 4)) {
        it.antiClockwiseQuarterTurnAboutYAxis()
    }

    fun rotateZ(times: Int) = repeatedlyApply(Math.floorMod(times, 4)) {
        it.antiClockwiseQuarterTurnAboutZAxis()
    }

    private fun rotateTopSlice(times: Int) =
        repeatedlyApply(Math.floorMod(times, 4)) { it.antiClockwiseQuarterTurnOfTopSlice() }

    private fun antiClockwiseQuarterTurnOfTopSlice() = Cube(
        listOf(
            this.faces[0].quarterTurnLeft(),
            this.faces[4].substring(0..2) + this.faces[1].substring(3..8),
            this.faces[1].substring(0..2) + this.faces[2].substring(3..8),
            this.faces[2].substring(0..2) + this.faces[3].substring(3..8),
            this.faces[3].substring(0..2) + this.faces[4].substring(3..8),
            this.faces[5]
        )
    )

    private fun antiClockwiseQuarterTurnAboutXAxis() = Cube(
        listOf(
            this.faces[3].halfTurn(),
            this.faces[0],
            this.faces[2].quarterTurnLeft(),
            this.faces[5].halfTurn(),
            this.faces[4].quarterTurnRight(),
            this.faces[1]
        )
    )

    private fun antiClockwiseQuarterTurnAboutYAxis() = Cube(
        listOf(
            this.faces[0].quarterTurnLeft(),
            this.faces[4],
            this.faces[1],
            this.faces[2],
            this.faces[3],
            this.faces[5].quarterTurnRight()
        )
    )

    private fun antiClockwiseQuarterTurnAboutZAxis() = Cube(
        listOf(
            this.faces[2].quarterTurnLeft(),
            this.faces[1].quarterTurnLeft(),
            this.faces[5].quarterTurnLeft(),
            this.faces[3].quarterTurnRight(),
            this.faces[0].quarterTurnLeft(),
            this.faces[4].quarterTurnLeft()
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

private fun String.quarterTurnLeft(): String =
    "${this[2]}${this[5]}${this[8]}${this[1]}${this[4]}${this[7]}${this[0]}${this[3]}${this[6]}"

private fun String.halfTurn(): String =
    this.repeatedlyApply(2) { it.quarterTurnLeft() }

private fun String.quarterTurnRight(): String =
    this.repeatedlyApply(3) { it.quarterTurnLeft() }

private fun Cube.translateMike() = listOf(
    this.faces[1], this.faces[3], this.faces[4], this.faces[2], this.faces[0], this.faces[5].reversed()
)