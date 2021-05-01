package com.company;

/**
 * stuff about 2DrawCard card
 * it makes next player to grab 2 cards from bank
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class TwoDrawCard extends ActionCard{
    /**
     * constructor of this class
     * @param color color of card
     */
    public TwoDrawCard( String color) {
        super(7, color, 10);
    }
    /**
     * if next player doesn't have 7 card has to grab four card
     * else sth else will happen
     * cardsToPickUp of game increases by 2
     * @param game game of current game
     */
    @Override
    public void action(Game game) {
        int indexNextPlayer =  game.nextTurn(game.getCurTurn(), game.getRotation());
        Player nextPlayer = game.getPlayers().get(indexNextPlayer);

        boolean flag = true;

        for(Card card : nextPlayer.getCardsInHand())
            if( card instanceof TwoDrawCard || card instanceof FourDrawCard )   { flag = false;  break; }
        if(flag) {
            System.out.printf("Next Player picked up %d cards!\n", game.getCardsToPickUp() + 2);
            for(int i = 0; i < game.getCardsToPickUp() + 2; i++)
                game.grabCard(nextPlayer);
            //game.setCurTurn(game.nextTurn(game.getCurTurn(), game.getRotation()));
            game.setCardsToPickUp(0);
        } else {
            game.setCardsToPickUp(game.getCardsToPickUp() + 2);
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
