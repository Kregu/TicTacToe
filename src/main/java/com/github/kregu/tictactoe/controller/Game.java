package com.github.kregu.tictactoe.controller;


import com.github.kregu.tictactoe.view.ConsoleView;

import java.util.Objects;

public class Game {
    public void startGame(ConsoleView view) {
        view.showGameName();
        view.showStartMenu();

        while(true) {
            String input = view.getStringInput().toLowerCase();
            if (Objects.equals(input, "x")) {
                System.exit(0);
            } else if (Objects.equals(input, "s")) {
                break;
            }
        }
    }
}
