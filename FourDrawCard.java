package com.company;

/**
 * stuff about 4WildDraw card
 * it makes next player to grab 4 cards from bank
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class FourDrawCard extends ActionCard{
    /**
     * constructor of this class
     */
    public FourDrawCard() {
        super(7, "Black", 15 );
    }

    /**
     * if next player doesn't have 7 card has to grab four card
     * else sth else will happen
     * cardsToPickUp of game increases by 4
     * @param game game of current game
     */
    @Override
    public void action(Game game) {
        int indexNextPlayer =  game.nextTurn(game.getCurTurn(), game.getRotation());
        Player nextPlayer = game.getPlayers().get(indexNextPlayer);

        boolean flag = true;
        for(Card card : nextPlayer.getCardsInHand())
            if( card instanceof TwoDrawCard )   { flag = false;  break; }
        if(flag) {
            System.out.printf("Next Player picked up %d cards!\n", game.getCardsToPickUp() + 4);
            for(int i = 0; i < game.getCardsToPickUp() + 4; i++)
                game.grabCard(nextPlayer);
            //game.setCurTurn(game.nextTurn(game.getCurTurn(), game.getRotation()));
            game.setCardsToPickUp(0);
        } else {
            game.setCardsToPickUp(game.getCardsToPickUp() + 4);
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
