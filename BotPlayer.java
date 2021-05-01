package com.company;

import java.util.LinkedList;

/**
 * if a player is Bot, use this class
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class BotPlayer extends Player {
    /**
     * constructor of this class
     * @param cardsInHand linked list of cards that player own for now
     */
    public BotPlayer(LinkedList<Card> cardsInHand) {
        super(cardsInHand);
    }
}
