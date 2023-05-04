package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Account.Card;

import java.util.ArrayList;

/**
 * Reads and writes from the cards.csv file
 */
public class CardFileReader extends FileReader{
    private final String path = "cards.csv";

    /**
     * Constructor
     */
    public CardFileReader() {
        super("cards.csv");
    }

    /**
     * Reads the lines from the file and returns an ArrayList of cards
     * @return ArrayList of cards from the file
     */
    public ArrayList<Card> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Card> cards = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    /**
     * Writes the cards to the file
     * @param cards
     */
    public void writeLines(ArrayList<Card> cards){
        ArrayList<String> lines = new ArrayList<>();
        for (Card card : cards){
            lines.add(card.toString());
        }
        this.write(lines);
    }
}
