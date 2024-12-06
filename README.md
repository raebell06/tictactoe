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
