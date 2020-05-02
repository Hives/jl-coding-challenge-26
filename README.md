# John Lewis Coding Challenge 26

## Manipulating a Rubik's Cube

### Instructions

<https://coding-challenges.jl-engineering.net/challenges/challenge-26/>

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
        ┌───────┐                         ┌───────┐
        │ 1 2 3 │                         │ A B C │
        │ 4 5 6 │                         │ D E F │
        │ 7 8 9 │                         │ G H I │
┌───────┼───────┼───────┬───────┐ ┌───────┼───────┼───────┬───────┐
│ 1 2 3 │ 1 2 3 │ 1 2 3 │ 1 2 3 │ │ j k l │ J K L │ S T U │ a b c │
│ 4 5 6 │ 4 5 6 │ 4 5 6 │ 4 5 6 │ │ m n o │ M N O │ V W X │ d e f │
│ 7 8 9 │ 7 8 9 │ 7 8 9 │ 7 8 9 │ │ p q r │ P Q R │ Y Z ! │ g h i │
└───────┼───────┼───────┴───────┘ └───────┼───────┼───────┴───────┘
        │ 1 2 3 │                         │ s t u │
        │ 4 5 6 │                         │ v w x │
        │ 7 8 9 │                         │ y z ? │
        └───────┘                         └───────┘
```
