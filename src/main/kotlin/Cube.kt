data class Cube(val faces: List<String>) {
    fun rotateSlice(face: Face, times: Int) =
        applyRotation(moveFaceToTop(face))
            .rotateTopSlice(times)
            .applyRotation(moveFaceToTop(face).inverse())

    fun rotateCube(axis: Axis, times: Int) = repeatedlyApply(Math.floorMod(times, 4)) {
        it.antiClockwiseQuarterTurnAround(axis)
    }

    private fun applyRotation(rotation: Rotation) = rotateCube(rotation.axis, rotation.times)

    private fun moveFaceToTop(face: Face) = when (face) {
        Face.TOP -> Rotation(Axis.X, 0)
        Face.BOTTOM -> Rotation(Axis.X, 2)
        Face.RIGHT -> Rotation(Axis.Z, 1)
        Face.LEFT -> Rotation(Axis.Z, -1)
        Face.FRONT -> Rotation(Axis.X, -1)
        Face.BACK -> Rotation(Axis.X, 1)
    }

    private fun antiClockwiseQuarterTurnAround(axis: Axis): Cube = when (axis) {
        Axis.X -> {
            this.antiClockwiseQuarterTurnAboutXAxis()
        }
        Axis.Y -> {
            this.antiClockwiseQuarterTurnAboutYAxis()
        }
        Axis.Z -> {
            this.antiClockwiseQuarterTurnAboutZAxis()
        }
    }

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
}

private fun String.quarterTurnLeft(): String =
    "${this[2]}${this[5]}${this[8]}${this[1]}${this[4]}${this[7]}${this[0]}${this[3]}${this[6]}"

private fun String.halfTurn(): String =
    this.repeatedlyApply(2) { it.quarterTurnLeft() }

private fun String.quarterTurnRight(): String =
    this.repeatedlyApply(3) { it.quarterTurnLeft() }

private data class Rotation(val axis: Axis, val times: Int) {
    fun inverse() = Rotation(axis, -times)
}

private tailrec fun <T> T.repeatedlyApply(n: Int, action: (T) -> T): T {
    if (n < 0) throw Exception("number of applications must be positive")
    return if (n == 0) {
        this
    } else {
        action(this).repeatedlyApply(n - 1, action)
    }
}

private fun Cube.translateMike() = listOf(
    this.faces[1], this.faces[3], this.faces[4], this.faces[2], this.faces[0], this.faces[5].reversed()
)
