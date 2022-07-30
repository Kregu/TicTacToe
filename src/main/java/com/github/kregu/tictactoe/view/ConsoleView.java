package com.github.kregu.tictactoe.view;

import com.github.kregu.tictactoe.controller.Controller;
import com.github.kregu.tictactoe.model.Board;
import com.github.kregu.tictactoe.model.Player;

import java.util.Scanner;

public class ConsoleView implements View {


  static final Controller controller = new Controller();
  static Scanner input = new Scanner(System.in);
  public static String getStringInput() {
    return input.nextLine();
  }


  public void showBoard(Board board) {
    clearConsole();
    System.out.println(board);
  }

  public void showGameName() {
    System.out.println("""
                    #######                 #######                 #######
                       #        #     ####     #       ##     ####     #      ####   ######
                       #        #    #    #    #      #  #   #    #    #     #    #  #
                       #        #    #         #     #    #  #         #     #    #  #####
                       #        #    #         #     ######  #         #     #    #  #
                       #        #    #    #    #     #    #  #    #    #     #    #  #
                       #        #     ####     #     #    #   ####     #      ####   ######
            """
    );
  }


  public boolean move(Board board, Player[] players) {
    Player currentPlayer = controller.currentPlayer(board, players);
    int[] coordinate = new int[2];

    if (currentPlayer == null) {
      System.out.println("No moves left!");
      return false;
    }
    System.out.printf("current player: %s\n", currentPlayer.name());
    for (int i = 0; i < 2; i++) {

      System.out.printf("move to %s: ", i == 0 ? "X" : "Y");
      coordinate[i] = parseCoordinates(getStringInput());
      while (coordinate[i] < 0 || coordinate[i] > 2) {
        System.out.println("Position not on board.");
        System.out.printf("move to %s: ", i == 0 ? "X" : "Y");
        coordinate[i] = parseCoordinates(getStringInput());
      }
    }

    if (!controller.checkCollision(coordinate, board)){
      board.changeBoard(coordinate, currentPlayer.name());
    }
    showBoard(board);

    return !controller.isGameOver(board,currentPlayer);
  }


  private void clearConsole() {
    final int screenLines = 80;
    System.out.println("\n".repeat(screenLines));
  }


  private static int parseCoordinates (String coordinate) {
    return switch (coordinate) {
      case "0" -> 0;
      case "1" -> 1;
      case "2" -> 2;
      default -> 5;
    };
  }
}

