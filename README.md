# tictactoe
**Overview**

This project is a simple command-line implementation of Tic Tac Toe in Java. It allows two players to take turns placing their marks ("X" and "O") on a 3x3 grid until one player wins or the game ends in a draw.

The program demonstrates several key concepts of discrete structures, including graph theory, set theory, logic, and algorithmic problem-solving.

**How it works** 
1. Initialization:
A 3x3 grid is created using Java Swing buttons, each representing a cell on the board.
Buttons are assigned event listeners to handle user interactions.
2. Player Input:
Players click on a cell to place their mark ("X" or "O").
The program validates the move, ensuring the cell is not already occupied.
3. Win/Draw Check:
After every move, the program checks:
If the current player has satisfied a winning condition.
If the board is full (resulting in a draw).
4. Game Reset:
The board resets after a game ends (win or draw), allowing players to start over

# Discrete Structures Topics used to develop tic tac toe 
Although various key discrete structures and topics aided in developing my tic-tac-toe game, listed below are the ones that proved most notable throughout the design process. 

**1. Set Theory:** 

Winning Subsets:
Each possible winning condition ({0, 1, 2}, {3, 4, 5}, etc.) is treated as a subset of the board's cells.
The program checks if a player’s moves form a subset that matches any winning condition.
Board State Validation:
Empty cells form a subset of the board, which is checked to determine valid moves.

**2. Boolean Logic:**
Win and Draw Logic:
Boolean operations are used to evaluate:
If all three cells in a winning condition contain the same mark (X or O).
If all cells are filled without satisfying any winning condition.
Logical conditions are applied to enable error checking (e.g., preventing moves on already occupied cells).
