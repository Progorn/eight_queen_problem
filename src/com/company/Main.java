package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();
        game.finishConfiguration(Game.ONE);
        System.out.println("Anzahl der Lösungen: " + game.solutions);
    }
}
