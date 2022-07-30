package com.github.kregu.tictactoe.controller;

import com.github.kregu.tictactoe.model.Board;
import com.github.kregu.tictactoe.model.Player;

public class Controller {


  public boolean checkCollision(int[] move, Board board) {
    char[][] gameBoard = board.getBoard();
    return gameBoard[move[0]][move[1]] != ' ';
  }


  public Player currentPlayer(Board board, Player[] players) {
    int countFigure = board.getFiguresCount();

    if (countFigure == board.getBoard().length  * board.getBoard()[0].length)
      return null;

    if (countFigure % 2 == 0)
      return players[0];

    return players[1];
  }


  public boolean isGameOver(Board board, Player player) {
    char ch = player.name();
    char[][] gameBoard = board.getBoard();

    if (gameBoard[0][0] == ch && gameBoard[0][1] == ch && gameBoard[0][2] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[1][0] == ch && gameBoard[1][1] == ch && gameBoard[1][2] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[2][0] == ch && gameBoard[2][1] == ch && gameBoard[2][2] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[0][0] == ch && gameBoard[1][0] == ch && gameBoard[2][0] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[0][1] == ch && gameBoard[1][1] == ch && gameBoard[2][1] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[0][2] == ch && gameBoard[1][2] == ch && gameBoard[2][2] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[0][0] == ch && gameBoard[1][1] == ch && gameBoard[2][2] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[2][0] == ch && gameBoard[1][1] == ch && gameBoard[0][2] == ch) {
      System.out.println("game is over, player " + ch + " wins");
      return true;
    }
    if (gameBoard[0][0] != ' ' && gameBoard[0][1] != ' ' && gameBoard[0][2] != ' '
            && gameBoard[1][0] != ' ' && gameBoard[1][1] != ' ' && gameBoard[1][2] != ' '
            && gameBoard[2][0] != ' ' && gameBoard[2][1] != ' ' && gameBoard[2][2] != ' ') {
      System.out.println("game is over, tie");
      return true;
    }
    return false;
  }
}

