package com.company;

/**
 * You have another turn to play if you use this card
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class BonusCard extends ActionCard{
    /**
     * constructor of this class
     * @param color color of card
     */
    public BonusCard(String color) {
        super(8, color, 8);
    }

    /**
     * current player, play another round with specific rules.
     * @param game game of current game
     * @throws InterruptedException for thread.sleep
     */
    @Override
    public void action(Game game) throws InterruptedException {
        if(game.getTopCard().getNumber() == 15) {
            System.out.println("Last Played Card: WildCard change to -> " + game.getBoardColor() );
        }else {
            System.out.println("Last Played Card: " + game.getTopCard().toString());
        }
        System.out.println("\nYour turn...Again");

        game.oneTurn(false);

        if(game.getPlayableCards().size() == 0){
            System.out.println("Picked Up a card");
            game.applyGrabCard();
        }

    }

    /**
     * @return extend Card class toString method
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
