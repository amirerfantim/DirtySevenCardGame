package com.company;

/**
 * by playing this card
 * player can change color of game/boardColor to another color
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public class WildCard extends ActionCard{
    /**
     * constructor of this class
     * @param color color of card
     */
    public WildCard(String color) {
        super(12, color, 12);
    }

    /**
     * change color of game/boardColor to another color
     * @param game game of current game
     */
    @Override
    public void action(Game game) {
        Player currentPlayer = game.getPlayers().get(game.getCurTurn());
        String[] colors = new String[]{"Black", "Red", "Green", "Yellow"};

        if(currentPlayer instanceof HumanPlayer) {
            while (true) {
                System.out.println("choose a color.[Enter row number]" + " 1-black " + Card.ANSI_RED +" 2-red " +
                        Card.ANSI_GREEN +" 3-green " + Card.ANSI_YELLOW + " 4-yellow" + Card.ANSI_RESET);
                try {
                    game.setBoardColor(colors[game.getInt() - 1]);
                    game.getTopCard().setNumber(15);
                    return;
                } catch (Exception e) {
                    System.out.println("not valid");
                }
            }
        }else {
            for (Card card : currentPlayer.getCardsInHand()) {
                if (card instanceof SimpleCard) {
                    game.setBoardColor(((SimpleCard) card).getColor());
                    game.getTopCard().setNumber(15);
                    return;
                }
            }
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
