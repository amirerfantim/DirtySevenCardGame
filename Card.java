package com.company;

/**
 * class to declare a card with it's specification
 *   @author Amirerfan Teimoory
 *   @version 1.0
 */
public abstract class Card {
    /**
     * number of card
     */
    private int number;
    /**
     * color of card
     */
    private String color;
    /**
     * point of card
     */
    private int point;
    /**
     * Ansi-codes to print colorful
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";

    /**
     * constructor of Card class
     * @param number number of card
     * @param color color of card
     * @param point point of card
     */
    public Card(int number, String color, int point) {
        this.number = number;
        this.color = color;
        this.point = point;
    }

    /**
     * get number of card
     * @return number of card
     */
    public int getNumber() {
        return number;
    }

    /**
     * get color of card
     * @return color of card
     */
    public String getColor() {
        return color;
    }

    /**
     * get point of card
     * @return point of card
     */
    public int getPoint() {
        return point;
    }

    /**
     * set color of card
     * @return color of card
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get number of card
     * @return number of card
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return string of cards view
     */
    @Override
    public String toString() {
        String view = "";

        if(color.equals("Black")){
            view =  ANSI_BLACK + "\n┍━━━━━━━━┑\n" +
                        "│ c    l │\n" +
                        "│        │\n" +
                        "│ l    c │\n" +
                        "┕━━━━━━━━┙" +
                        Card.ANSI_RESET ;
            view =view.replaceAll("l", "*");
        }else if(color.equals("Red")){
            view = ANSI_RED + "\n┍━━━━━━━━┑\n" +
                        "│ c    l │\n" +
                        "│        │\n" +
                        "│ l    c │\n" +
                        "┕━━━━━━━━┙" +
                        Card.ANSI_RESET ;
            view =view.replaceAll("l", "\u2663");
        }else if(color.equals("Yellow")){
            view =ANSI_YELLOW + "\n┍━━━━━━━━┑\n" +
                        "│ c    l │\n" +
                        "│        │\n" +
                        "│ l    c │\n" +
                        "┕━━━━━━━━┙" +
                        Card.ANSI_RESET ;
            view =view.replaceAll("l", "\u2660");
        }else{
            view = ANSI_GREEN + "\n┍━━━━━━━━┑\n" +
                        "│ c    l │\n" +
                        "│        │\n" +
                        "│ l    c │\n" +
                        "┕━━━━━━━━┙" +
                        Card.ANSI_RESET ;
            view =view.replaceAll("l", "\u2666");
        }

        switch (getNumber()){
            case 11:{
                view = view.replaceAll("c", "A");
            }
            case 12:{
                view = view.replaceAll("c", "B");
            }
            case 13:{
                view = view.replaceAll("c", "C");
            }
            case 14:{
                view = view.replaceAll("c", "D");
            }
            case 10:{
                view = view.replaceAll(" c", "10");
            }
            default:{
                view = view.replaceAll("c", "" + getNumber());
            }
        }
        return view;

    }

}
