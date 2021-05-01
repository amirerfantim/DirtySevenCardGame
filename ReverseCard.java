package com.company;

/**
 * reverse the rotation of the game
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class ReverseCard extends ActionCard{
    /**
     * constructor of this class
     * @param color color of card
     */
    public ReverseCard(String color) {
        super(10, color, 10);
    }

    /**
     * reverse the rotation of the game
     * @param game game of current game
     */
    @Override
    public void action(Game game) {
        switch (game.getRotation()){
            case 1: {
                game.setRotation(2);
                break;
            }
            default:{
                game.setRotation(1);
            }
        }
    }

    /**
     * @return extends toString Card class
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
