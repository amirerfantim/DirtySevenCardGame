package com.company;

/**
 * define a card with ability to do something.
 * @author Amirerfan Teimoory
 * @version 1.0
 */
public abstract class ActionCard extends Card {
    /**
     * constructor of this class
     * @param number number of card
     * @param color color of card
     * @param point point of card
     */
    public ActionCard(int number, String color, int point) {
        super(number, color, point);
    }

    /**
     * do some specific action
     * @param game game of current game
     */
    public abstract void action(Game game) throws InterruptedException;

    /**
     * @return Card class toString method
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
