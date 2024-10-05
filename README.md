# Sudoku board generator in Java
1. Algorithm creates a validly filled sudoku board
2. It removes the desired amount of values to create the puzzle:
    - It removes one value, checks wether the puzzle is still solvable and unique
    - Repeats until it reaches the desired amount of deletions
3. It saves and shows the correct unique solution

## Example output:
```
Board for solving:
- - 6 | 9 5 7 | 3 1 2 
5 - - | 1 - - | - 9 - 
- 7 9 | 2 3 8 | - 6 5 
---------------------
- 3 - | - 4 1 | 6 5 9 
8 6 5 | - - - | 1 4 7 
- - - | 5 - 6 | 2 - - 
---------------------
6 5 - | 4 - 3 | - - - 
- 4 8 | 7 1 9 | - 2 - 
7 - 1 | 6 2 - | - - - 

Solution:
4 8 6 | 9 5 7 | 3 1 2 
5 2 3 | 1 6 4 | 7 9 8 
1 7 9 | 2 3 8 | 4 6 5 
---------------------
2 3 7 | 8 4 1 | 6 5 9 
8 6 5 | 3 9 2 | 1 4 7 
9 1 4 | 5 7 6 | 2 8 3 
---------------------
6 5 2 | 4 8 3 | 9 7 1 
3 4 8 | 7 1 9 | 5 2 6 
7 9 1 | 6 2 5 | 8 3 4 
```
