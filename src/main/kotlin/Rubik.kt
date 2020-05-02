data class Cube(val faces: List<String>) {
    fun rotateTopSlice90DegreesAntiClockwise() = Cube(
        listOf(
            this.faces[0].rotateFaceAntiClockwise(),
            this.faces[4].substring(0..2) + this.faces[1].substring(3..8),
            this.faces[1].substring(0..2) + this.faces[2].substring(3..8),
            this.faces[2].substring(0..2) + this.faces[3].substring(3..8),
            this.faces[3].substring(0..2) + this.faces[4].substring(3..8),
            this.faces[5]
        )
    )

    fun rotateTopSlice180Degrees() = this
        .rotateTopSlice90DegreesAntiClockwise()
        .rotateTopSlice90DegreesAntiClockwise()

    fun rotateTopSlice90DegreesClockwise() = this
        .rotateTopSlice90DegreesAntiClockwise()
        .rotateTopSlice90DegreesAntiClockwise()
        .rotateTopSlice90DegreesAntiClockwise()
}

private fun String.rotateFaceAntiClockwise(): String =
    "${this[2]}${this[5]}${this[8]}${this[1]}${this[4]}${this[7]}${this[0]}${this[3]}${this[6]}"