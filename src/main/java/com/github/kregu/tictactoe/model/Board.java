package com.github.kregu.tictactoe.model;

import java.util.Arrays;

public class Board {

  private final char[][] board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};


  public void changeBoard(int[] move, char symbol) {
    board[move[0]][move[1]] = symbol;
  }


  public char[][] getBoard() {
    return board;
  }


  public int getFiguresCount() {
    int count = 0;
    for (char[] each : board) {
      for (char ch : each) {
        if (ch != ' '){
          count += 1;
        }
      }
    }
    return count;
  }


  public void clear() {
    for (char[] row : board) {
      Arrays.fill(row, ' ');
    }
  }


  @Override
  public String toString() {

    return """
                      %s|%s|%s
                      —————
                      %s|%s|%s
                      —————
                      %s|%s|%s
                   """
            .formatted(this.board[0][0], this.board[0][1], this.board[0][2],
            this.board[1][0], this.board[1][1], this.board[1][2],
            this.board[2][0], this.board[2][1], this.board[2][2]);
  }
}

