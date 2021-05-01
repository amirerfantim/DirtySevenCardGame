package com.company;

import java.util.LinkedList;
import java.util.Random;

/**
 * just to create starter cards of game and share it between players
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */

public class CardsInHand {
    /**
     * linked list of cards that are in bank
     */
    private LinkedList<Card> bank = new LinkedList<>() ;

    {

        {
            int i;
            for(i = 2; i <= 14; i++){
                if(i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 13 || i == 14) {
                    bank.add(new SimpleCard(i, "Black", i));
                    bank.add( new SimpleCard(i, "Red", i));
                    bank.add(new SimpleCard(i, "Green", i));
                    bank.add(new SimpleCard(i, "Yellow", i));
                }
            }

            bank.add(new FourDrawCard());
            bank.add((new TwoDrawCard("Red")));
            bank.add((new TwoDrawCard("Green")));
            bank.add((new TwoDrawCard("Yellow")));

            bank.add((new GiveAwayCard("Red")));
            bank.add((new GiveAwayCard("Green")));
            bank.add((new GiveAwayCard("Yellow")));
            bank.add((new GiveAwayCard("Black")));

            bank.add((new ReverseCard("Red")));
            bank.add((new ReverseCard("Green")));
            bank.add((new ReverseCard("Yellow")));
            bank.add((new ReverseCard("Black")));

            bank.add((new SkipCard("Red")));
            bank.add((new SkipCard("Green")));
            bank.add((new SkipCard("Yellow")));
            bank.add((new SkipCard("Black")));

            bank.add((new WildCard("Red")));
            bank.add((new WildCard("Green")));
            bank.add((new WildCard("Yellow")));
            bank.add((new WildCard("Black")));

            bank.add((new BonusCard("Red")));
            bank.add((new BonusCard("Green")));
            bank.add((new BonusCard("Yellow")));
            bank.add((new BonusCard("Black")));

        }
    }

    /**
     * playersCount = number of players
     * humanCount = number of players that human
     */
    private int playersCount, humanCount;
    /**
     * linked list of players that are playing
     */
    private LinkedList<Player> players = new LinkedList<>();

    /**
     * constructor of this class
     * @param playersCount number of players
     * @param humanCount number of players that are human
     */
    public CardsInHand(int playersCount, int humanCount) {
        this.playersCount = playersCount;
        this.humanCount = humanCount;
    }

    /**
     * to share cards between players
     */
    public void createStarterCards(){
        for(int outerLoop = 0; outerLoop < playersCount; outerLoop++){
            LinkedList<Card> starterCards = new LinkedList<>();
            for(int innerLoop = 0; innerLoop < 7; innerLoop++){
                Random random = new Random();
                Card card = bank.get(random.nextInt(bank.size()));
                bank.remove(card);
                starterCards.add(card);
            }
            if(outerLoop < humanCount) {
                players.add(new HumanPlayer(starterCards));
            }else{
                players.add(new BotPlayer(starterCards));
            }
        }
    }

    /**
     * get bank
     * @return bank liked list of cards
     */
    public LinkedList<Card> getBank() {
        return bank;
    }

    /**
     * get players
     * @return players linked list of player
     */
    public LinkedList<Player> getPlayers() {
        return players;
    }

}
