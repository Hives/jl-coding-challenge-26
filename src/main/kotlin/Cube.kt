data class Cube(val faces: List<String>) {

    fun rotateFace(face: Face, quarterTurns: Int) =
        applyRotation(moveFaceToTop(face))
            .rotateTopFace(quarterTurns)
            .applyRotation(moveFaceToTop(face).inverse)

    fun rotateCube(axis: Axis, quarterTurns: Int) =
        repeatedlyApply(translateToCCW(quarterTurns)) { it.quarterTurnCCWAbout(axis) }

    private fun translateToCCW(quarterTurns: Int) = Math.floorMod(quarterTurns, 4)

    private fun applyRotation(rotation: Rotation) = rotateCube(rotation.axis, rotation.quarterTurns)

    private fun moveFaceToTop(face: Face) = when (face) {
        Face.TOP -> Rotation(Axis.X, 0)
        Face.BOTTOM -> Rotation(Axis.X, 2)
        Face.RIGHT -> Rotation(Axis.Z, 1)
        Face.LEFT -> Rotation(Axis.Z, -1)
        Face.FRONT -> Rotation(Axis.X, -1)
        Face.BACK -> Rotation(Axis.X, 1)
    }

    private fun quarterTurnCCWAbout(axis: Axis): Cube = when (axis) {
        Axis.X -> this.quarterTurnCCWAboutXAxis()
        Axis.Y -> this.quarterTurnCCWAboutYAxis()
        Axis.Z -> this.quarterTurnCCWAboutZAxis()
    }

    private fun quarterTurnCCWAboutXAxis() = Cube(
        listOf(
            this.faces[3].halfTurn(),
            this.faces[0],
            this.faces[2].quarterTurnLeft(),
            this.faces[5].halfTurn(),
            this.faces[4].quarterTurnRight(),
            this.faces[1]
        )
    )

    private fun quarterTurnCCWAboutYAxis() = Cube(
        listOf(
            this.faces[0].quarterTurnLeft(),
            this.faces[4],
            this.faces[1],
            this.faces[2],
            this.faces[3],
            this.faces[5].quarterTurnRight()
        )
    )

    private fun quarterTurnCCWAboutZAxis() = Cube(
        listOf(
            this.faces[2].quarterTurnLeft(),
            this.faces[1].quarterTurnLeft(),
            this.faces[5].quarterTurnLeft(),
            this.faces[3].quarterTurnRight(),
            this.faces[0].quarterTurnLeft(),
            this.faces[4].quarterTurnLeft()
        )
    )

    private fun rotateTopFace(quarterTurns: Int) =
        repeatedlyApply(translateToCCW(quarterTurns)) { it.quarterTurnCCWOfTopFace() }

    private fun quarterTurnCCWOfTopFace() = Cube(
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

private data class Rotation(val axis: Axis, val quarterTurns: Int) {
    val inverse
        get() = Rotation(axis, -quarterTurns)
}

private tailrec fun <T> T.repeatedlyApply(n: Int, action: (T) -> T): T {
    if (n < 0) throw Exception("number of applications must be positive")
    return if (n == 0) {
        this
    } else {
        action(this).repeatedlyApply(n - 1, action)
    }
}
