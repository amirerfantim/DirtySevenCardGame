package com.company;

import java.util.LinkedList;

/**
 * if a player is Human, use this class
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class HumanPlayer extends Player{
    /**
     * constructor of this class
     * @param cardsInHand linked list of cards that player own for now
     */
    public HumanPlayer(LinkedList<Card> cardsInHand) {
        super(cardsInHand);
    }

}
