package com.company;

public class Main {

    /**
     * main method to start the 8-queen-game-analysis.
     * @param args String[]
     */
    public static void main(String[] args) {
	// write your code here
        Game game = new Game();
        game.finishConfiguration(Game.ONE);
        System.out.println("Anzahl der gefunden Lösungen: " + game.solutions);
    }
}
