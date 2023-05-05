package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Cards.Card;
import com.mycompany.projectm3.lib.DateCalculator;

import java.util.ArrayList;
import java.util.Date;

/**
 * Reads and writes from the cards.csv file
 */
public class CardFileReader extends FileReader{
    /**
     * Constructor
     */
    public CardFileReader() {
        super("data/cards.csv");
    }

    /**
     * Reads the lines from the file and returns an ArrayList of cards
     * @return ArrayList of cards from the file
     */
    public ArrayList<Card> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Card> cards = new ArrayList<>();
        for (String line : lines){
            String[] lineSplit = line.split(",");
            long cardNumber = Long.parseLong(lineSplit[0]);
            int securityNumber = Integer.parseInt(lineSplit[1]);
            Date expirationDate = DateCalculator.stringToDate(lineSplit[2]);
            int PIN = Integer.parseInt(lineSplit[3]);
            int acc_id = Integer.parseInt(lineSplit[4]);
            Card card = new Card(cardNumber, securityNumber, expirationDate, PIN, acc_id);
            cards.add(card);
        }
        return cards;
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
