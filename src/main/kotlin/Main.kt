fun main() {
    val cube = Cube(listOf("WWWWWWWWW","GGGGGGGGG","RRRRRRRRR","YYYYYYYYY","OOOOOOOOO","BBBBBBBBB"))

    println(cube.rotateFace(Face.TOP, -1).translateMike())
    println(cube.rotateFace(Face.BOTTOM, -1).translateMike())
    println(cube.rotateFace(Face.LEFT, -1).translateMike())
    println(cube.rotateFace(Face.RIGHT, -1).translateMike())
    println(cube.rotateFace(Face.FRONT, -1).translateMike())
    println(cube.rotateFace(Face.BACK, -1).translateMike())

}

private fun Cube.translateMike() = listOf(
    this.faces[1], this.faces[3], this.faces[4], this.faces[2], this.faces[0], this.faces[5].reversed()
)
