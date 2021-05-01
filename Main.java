package com.company;

import java.util.Scanner;

public class Main {
    /**
     * Ansi-codes for colorful printing
     */
    public static final String	MAGENTA = "\u001B[35m";
    public static final String	CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";


    /**
     * get a int from user
     * @return int
     */
    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * get number of players
     * @return number of players
     */
    public static int getPlayersCount(){
        System.out.print("Enter number of players[3/4/5 players]: ");
        int playersCount = getInt();

        while(playersCount > 5 || playersCount < 3){
            System.out.print("Wrong input\nEnter number of players[3/4/5 players]: ");
            playersCount = getInt();
        }
        return playersCount;
    }

    /**
     * get game type -> 1 for single 2 for multi
     * @return game type
     */
    public static int getGameType(){
        System.out.print(MAGENTA + "1. Single Player" + CYAN + " 2. Multi Player: " + ANSI_RESET);
        int playersCount = getInt();

        while(playersCount > 2 || playersCount < 0){
            System.out.print("Wrong input\n"+ MAGENTA + "1. Single Player" + CYAN + " 2. Multi Player: " + ANSI_RESET);
            playersCount = getInt();
        }
        return playersCount;
    }

    public static void main(String[] args) throws InterruptedException {

        Game game;
        int playerCount;

        if (getGameType() == 1) {
            playerCount = getPlayersCount();
            game = new Game(playerCount, 1);
        } else {
            playerCount = getPlayersCount();
            game = new Game(playerCount, playerCount );
        }
        game.createGame();
        game.game();
        game.endingShowPoints();
        //game.endingShowCards();

    }
}
