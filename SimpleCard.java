package com.company;

/**
 * these cards have no actions/ they only have color & number
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class SimpleCard extends Card{
    /**
     * constructor of this class
     * @param number number of card
     * @param color color of card
     * @param point point of card
     */
    public SimpleCard(int number, String color, int point) {
        super(number, color, point);
    }

    /**
     * @return extends toString of Card class
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
