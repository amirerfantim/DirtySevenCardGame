package com.company;

import java.util.*;

/**
 * it is main class of program
 * this class manage the whole game
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */

public class Game {

    /**
     * cardsInHand -> cards that player has
     * bank -> cards in the bank of game
     * playersCount -> number of players that are playing
     * HumanCount -> number of players that are playing and are Human
     * boardColor -> current color of the board
     * players -> players that are playing
     * curTurn ->  index of current player
     * rotation -> 1 for clockWise 2 for Anti-clackWise
     * cardsToPickUp -> cards that player has to grab
     * topCard -> current top card of the game
     * playedCard -> last played card
     * currentPlayer -> current player that is playing
     */
    private CardsInHand cardsInHand;
    private LinkedList<Card> bank ;
    private int playersCount, humanCount;
    private String boardColor;
    private LinkedList<Player> players;
    private int curTurn = 0, rotation = 1, cardsToPickUp = 0;
    private Card topCard, playedCard;
    private Player currentPlayer;
    private LinkedList<Card> playableCards;

    /**
     * Ansi-codes for colorful printing
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String MAGENTA = "\u001B[35m";

    /**
     * @param playersCount number of players that are playing
     * @param humanCount number of players that are playing and are Human
     */
    public Game(int playersCount, int humanCount) {
        this.playersCount = playersCount;
        this.humanCount = humanCount;
    }

    /**
     * set color of the board
     * @param boardColor color of the board
     */
    public void setBoardColor(String boardColor) {
        this.boardColor = boardColor;
    }

    /**
     * set current turn ( index of current player )
     * @param curTurn index of current player
     */
    public void setCurTurn(int curTurn) {
        this.curTurn = curTurn;
    }

    /**
     * set rotation of game
     * @param rotation rotation of game
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    /**
     * set cards to grab
     * @param cardsToPickUp cards to grab
     */
    public void setCardsToPickUp(int cardsToPickUp) {
        this.cardsToPickUp = cardsToPickUp;
    }

    /**
     * get the color of the board
     * @return color of the board
     */
    public String getBoardColor() {
        return boardColor;
    }

    /**
     * get number of players
     * @returnnumber of players
     */
    public int getPlayersCount() {
        return playersCount;
    }

    /**
     * get cards to grab
     * @return cards to grab
     */
    public int getCardsToPickUp() {
        return cardsToPickUp;
    }

    /**
     * get rotation of game -> 1 for clockWise 2 for Anti-clackWise
     * @return rotation of game
     */
    public int getRotation() {
        return rotation;
    }

    /**
     * get playable cards
     * @return playable cards
     */
    public LinkedList<Card> getPlayableCards() {
        return playableCards;
    }

    /**
     * get players that are playing
     * @return players that are playing
     */
    public LinkedList<Player> getPlayers() {
        return players;
    }

    /**
     * get index of current player
     * @return index of current player
     */
    public int getCurTurn() {
        return curTurn;
    }

    /**
     * get top card of the game
     * @return top card of the game
     */
    public Card getTopCard() {
        return topCard;
    }

    /**
     * get current player of the game
     * @return  current player of the game
     */
    public Player getCurrentPlayer(){
        return players.get(curTurn);
    }

    /**
     * create stuff that we need to create a game
     */
    public void createGame(){

        cardsInHand = new CardsInHand(playersCount, humanCount);
        cardsInHand.createStarterCards();

        bank = cardsInHand.getBank();
        players = cardsInHand.getPlayers();

        topCard = firstTopCard();

    }

    /**
     * get a integer from user
     * @return int
     */
    public int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * @return first topCard of the game
     */
    public Card firstTopCard(){

        Random random = new Random();

        while (true){
            int index = random.nextInt(bank.size());
            if(bank.get(index) instanceof SimpleCard){
                return bank.get(index);
            }else{
                Card card = bank.get(index);
                bank.remove(card);
                bank.add(card);
            }
        }

    }

    /**
     * manage the whole game till it ends!
     * @throws InterruptedException thread.sleep
     */
    public void game() throws InterruptedException {
        int  firstCardToPickUp;

        Random random = new Random();

        curTurn = random.nextInt(playersCount);

        while(!endGame()){
            firstCardToPickUp =getCardsToPickUp();

            oneTurn(true);

            if(getCardsToPickUp() > 0 && firstCardToPickUp == getCardsToPickUp()) {
                System.out.println(getCardsToPickUp() + " Cards  pickedUp");
                for (int i = 0; i < getCardsToPickUp(); i++)
                    grabCard(currentPlayer);
                setCardsToPickUp(0);
            }


            if(topCard.getNumber() == 15 ) {
                System.out.println("Last Played Card: WildCard change to -> " + boardColor );
            }else  {
                System.out.println("Last Played Card: " + topCard.toString());
            }

            curTurn = nextTurn(curTurn, rotation);


        }


    }

    /**
     * manage a one turn of game
     * @param firstTime declare it is first time that this player playing this
     *                  round or not ( true -> first time / false -> not first time )
     * @throws InterruptedException thread.sleep
     */
    public void oneTurn(boolean firstTime) throws InterruptedException {
        int command;
        Random random = new Random();
        System.out.println("\nPlayer" + (curTurn + 1) + " Turn");

        currentPlayer = getCurrentPlayer();

        if(rotation == 1){
            System.out.println("Clockwise");
        }else{
            System.out.println("Anti-Clockwise");
        }

        if(topCard.getNumber() == 15){
            System.out.println("Top Card: Only " + boardColor );
            topCard.setColor(boardColor);
        }else{
            System.out.println("Top Card: " + topCard.toString());
        }

        Thread.sleep(2000);

        playableCards = new LinkedList<>();
        playableCards = currentPlayer.playableCards(currentPlayer.getCardsInHand(), topCard );

        if(players.get(curTurn) instanceof HumanPlayer){

            System.out.println(MAGENTA + "Your Cards: " + ANSI_RESET  +
                    ((HumanPlayer) currentPlayer).showCards(currentPlayer.getCardsInHand()));
            System.out.println(MAGENTA + "Playable Cards: " + ANSI_RESET +
                    ((HumanPlayer) currentPlayer).showCards(playableCards));

            if(playableCards.size() > 0) {
                System.out.print("Choose your Card from playable cards using it's number: ");
                command = getInt();

                while (command > playableCards.size()) {
                    System.out.print("Wrong Input!\nChoose your Card from playable cards using it's number: ");
                    command = getInt();
                }

                playedCard = playableCards.get(command - 1);
                applyPlayedCard();

            }else if(firstTime){
                applyGrabCard();
                System.out.println("You Cant play! -> you picked Up a card");
            }

        }else{

            if(playableCards.size() > 0){
                playedCard = playableCards.get(random.nextInt(playableCards.size()));
                applyPlayedCard();

            }else if(firstTime){
                applyGrabCard();
                System.out.println("Picked Up a card");

            }
        }
    }

    /**
     * when you play a card this method apply some changes in cardsInHand & bank
     * @throws InterruptedException thread.sleep
     */
    public void applyPlayedCard() throws InterruptedException {
        currentPlayer.getCardsInHand().remove(playedCard);
        bank.add(playedCard);
        topCard = playedCard;

        if(playedCard instanceof ActionCard) {
            ((ActionCard) playedCard).action(this);
        }
    }

    /**
     * apply grabCard method & handle exceptions
     * @throws InterruptedException sleep.thread
     */
    public void applyGrabCard() throws InterruptedException {

        grabCard(currentPlayer);
        playableCards = currentPlayer.playableCards(currentPlayer.getCardsInHand(), topCard );
        if(playableCards.size() > 0){
            playedCard = playableCards.get(0);
            applyPlayedCard();
        }
    }

    /**
     * grab a card from bank & add it to player's cardsInHand
     * @param player current player
     */
    public void grabCard(Player player){
        Card card = bank.get(1);
        bank.remove(1);
        player.getCardsInHand().add(card);
    }

    /**
     * check if game is end or not if ended -> true / else -> false
     * @return boolean that shows game is end or not
     */
    public boolean endGame(){
        int row = 1;
        for(Player player : players){
            if(player.getCardsInHand().size() == 0){
                System.out.println("Player" + row + " won!\n");
                return true;
            }
            row++;
        }
        return false;
    }

    /*
    public void endingShowCards(){
        int row = 1;
        for(Player player : players){
            System.out.println("Player" + row + " Cards: " + player.showCards(player.getCardsInHand()));
            System.out.println("-------------------");
            row++;
        }
    }

     */

    /**
     * calculate points of a player
     * @param player player that you want to measure
     * @return points  of the player
     */
    public int calculatePoint(Player player){
        LinkedList<Card> cards = player.getCardsInHand();
        int points = 0;
        for(Card card : cards){
            points += card.getPoint();
        }
        return points;
    }

    /**
     * show all player's points
     * sorted from low to high
     */
    public void endingShowPoints(){
        HashMap<String, Integer> notSortedPlayers =  new HashMap<>();
        int playerNumber = 1;

        for(Player player : players){
            notSortedPlayers.put("Player" + playerNumber, calculatePoint(player));
            playerNumber++;
        }
        HashMap<String, Integer> sortedPlayers =  sortByValue(notSortedPlayers);

        playerNumber = 1;
        for(String str : sortedPlayers.keySet()){
            System.out.println(playerNumber + "| " + str + " Points: " + sortedPlayers.get(str));
            playerNumber++;
        }

    }

    /**
     * sort a hash map by value
     * @param hm hash map that you want to sort
     * @return sorted hash map -> fro low to high by values
     */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /**
     * get a next player index
     * @param curTurn index of current player
     * @param rotation rotation of game
     * @return next player index
     */
    public int nextTurn(int curTurn, int rotation){
        if(curTurn == 0 && rotation == 2){
            return playersCount - 1;
        }else if(curTurn == playersCount - 1 && rotation == 1) {
            return 0;
        }
        else if(rotation == 1){
            return curTurn + 1;
        }else{
            return curTurn - 1;
        }

    }

}
