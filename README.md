# John Lewis Coding Challenge 26

## Manipulating a Rubik's Cube

### Instructions

<https://coding-challenges.jl-engineering.net/challenges/challenge-26/>

Running `main()` in `Main.kt` will calculate the examples from the instructions. In my wisdom I decided to lay the cube out differently to how it was specified, so the `translateMike()` function translates the cubes back into the format requested.

### Implementation

I implemented rotating the top face one quarter turn anticlockwise, and rotating the whole cube one quarter turn anticlockwise about each axis. I then created a general cube rotation by applying the simple rotations multiple times, and a general face rotation by rotating the cube so that the requested face is on top, applying the simple top face rotation function as many times as necessary, and then rotating the cube to return the face to its starting position.

```kotlin
// for example
val cube = Cube(listOf("WWWWWWWWW","GGGGGGGGG","RRRRRRRRR","YYYYYYYYY","OOOOOOOOO","BBBBBBBBB"))
val rotatedCube = cube.rotateFace(Face.RIGHT, 1).rotateCube(Axis.Y, -1)
```

Rotation functions take two parameters, either a face or an axis, followed by the number of quarter turns. A positive number means anticlockwise, negative means clockwise.

### Notes

The state of the cube is represented by a list of six faces. The faces are ordered Top, Front, Right, Back, Left, Bottom. (This is different to the ordering given in the instructions.) If you imagine flattening the faces into a map, the numbering is like this (zero indexed):

```
    ┌───┐
    │ 0 │
┌───┼───┼───┬───┐
│ 4 │ 1 │ 2 │ 3 │
└───┼───┼───┴───┘
    │ 5 │
    └───┘
```

The state of each face is represented by a string of 9 characters, one for each square. The order of the squares on each is face is as follows:

```
        ┌───────┐
        │ 1 2 3 │
        │ 4 5 6 │
        │ 7 8 9 │
┌───────┼───────┼───────┬───────┐
│ 1 2 3 │ 1 2 3 │ 1 2 3 │ 1 2 3 │
│ 4 5 6 │ 4 5 6 │ 4 5 6 │ 4 5 6 │
│ 7 8 9 │ 7 8 9 │ 7 8 9 │ 7 8 9 │
└───────┼───────┼───────┴───────┘
        │ 1 2 3 │
        │ 4 5 6 │
        │ 7 8 9 │
        └───────┘
```
