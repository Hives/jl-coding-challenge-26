# John Lewis Coding Challenge 26

## Manipulating a Rubik's Cube

### Instructions

<https://coding-challenges.jl-engineering.net/challenges/challenge-26/>

### Notes

The state of the cube is represented by a list of six faces. The faces are ordered Top, Front, Right, Back, Left, Bottom. (This is different to the ordering given in the instructions.) If you imagine flattening the faces into a map, the numbering is like this:

```
    ┌───┐
    │ 1 │
┌───┼───┼───┬───┐
│ 5 │ 2 │ 3 │ 4 │
└───┼───┼───┴───┘
    │ 6 │
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