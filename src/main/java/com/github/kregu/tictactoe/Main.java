package com.github.kregu.tictactoe;

import com.github.kregu.tictactoe.model.Board;
import com.github.kregu.tictactoe.model.Player;
import com.github.kregu.tictactoe.view.ConsoleView;

public class Main {

  public static void main(String[] args) {

    var view = new ConsoleView();
    var board = new Board();
    Player[] players = {new Player('X'), new Player('0')};

    view.showBoard(board);
    while (view.move(board, players)) {
      view.showBoard(board);
    }
  }
}

