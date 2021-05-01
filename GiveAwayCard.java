package com.company;

import java.util.LinkedList;
import java.util.Random;

/**
 * if you play this card
 * a random card from your cards goes to player that you choose
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class GiveAwayCard extends ActionCard{
    /**
     * constructor of this class
     * @param color color of card
     */
    public GiveAwayCard(String color) {
        super(2, color, 2);
    }

    /**
     * you choose a player -> a random card from your cards goes that player
     * @param game game of current game
     */
    @Override
    public void action(Game game) {
        Random random = new Random();

        LinkedList<Player> players = game.getPlayers();
        Player currentPlayer = game.getCurrentPlayer();
        Player targetPlayer;
        int targetPlayerIndex, yourIndex = 0;

        if(currentPlayer.getCardsInHand().size() > 0) {
            if (currentPlayer instanceof HumanPlayer) {
                System.out.println("Choose your player:");

                for (int i = 0; i < players.size(); i++) {
                    if (!(players.get(i).equals(currentPlayer))) {
                        System.out.print((i + 1) + ". Player" + (i + 1) + " | ");
                    }else{
                        yourIndex = i;
                    }
                }

                System.out.print("\nEnter player number: ");
                targetPlayerIndex = game.getInt() - 1;

                while (targetPlayerIndex == yourIndex || targetPlayerIndex > players.size() - 1){
                    System.out.print("\nWrong Input...\nEnter player number: ");
                    targetPlayerIndex = game.getInt() - 1;
                }

            } else {
                targetPlayerIndex = random.nextInt(game.getPlayersCount());
                targetPlayer = players.get(targetPlayerIndex);

                while (targetPlayer.equals(currentPlayer)) {
                    targetPlayerIndex = random.nextInt(game.getPlayersCount());
                    targetPlayer = players.get(targetPlayerIndex);
                }
            }

            Card card = currentPlayer.getCardsInHand().get(random.nextInt(currentPlayer.getCardsInHand().size()));

            targetPlayer = players.get(targetPlayerIndex);
            targetPlayer.getCardsInHand().add(card);
            currentPlayer.getCardsInHand().remove(card);
        }

    }

    /**
     * @return extends toString of Card class
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
