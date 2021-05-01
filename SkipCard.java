package com.company;

/**
 * this card skip from next player turn
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class SkipCard extends ActionCard{
    /**
     * constructor of this class
     * @param color color of card
     */
    public SkipCard(String color) {
        super(11, color, 11);
    }

    /**
     * skip from next player turn
     * @param game game of current game
     */
    @Override
    public void action(Game game) {
        game.setCurTurn(game.nextTurn(game.getCurTurn(), game.getRotation()));
    }

    /**
     * @return extends toString Card class
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
