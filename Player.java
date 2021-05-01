package com.company;

import java.util.LinkedList;
import java.util.Objects;

/**
 * stuff about a specific player & his/her cards
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public abstract class Player {
    /**
     * cards that player own for now
     */
    private LinkedList<Card> cardsInHand;

    /**
     * constructor of this class
     * @param cardsInHand cards that player has for now
     */
    public Player(LinkedList<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    /**
     * get cards that player has
     * @return player's cards in hand
     */
    public LinkedList<Card> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * to get playable cards that player can play in this turn
     * @param cardsInHand  cards that player own for now
     * @param topCard current games top card
     * @return LinkedList of playable cards that player can play in this turn
     */
    public LinkedList<Card> playableCards(LinkedList<Card> cardsInHand, Card topCard){

        LinkedList<Card> playableCard = new LinkedList<>();

        for(Card card : cardsInHand){

            if(topCard instanceof FourDrawCard || topCard instanceof TwoDrawCard
                    || card.getNumber() == topCard.getNumber() || card.getColor().equals(topCard.getColor())
                    || card instanceof WildCard || card instanceof FourDrawCard){
                playableCard.add(card);
            }
        }

        return playableCard;
    }

    /**
     * print a linkedList of cards
     * @param cardsInHand card's linkedLIst that you want to print
     * @return String to be printed or used.
     */
    public String showCards(LinkedList<Card> cardsInHand){
        StringBuilder str = new StringBuilder();
        int row = 1;
        for(Card card : cardsInHand){
            str.append("\n").append(row).append(". ").append(card.toString());
            row++;
        }
        return str.toString();
    }

    /**
     * check if two player are same or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(getCardsInHand(), player.getCardsInHand());
    }

    /**
     * this make a hashCode.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCardsInHand());
    }
}
