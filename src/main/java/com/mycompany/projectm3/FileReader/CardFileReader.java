package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Account.Card;

import java.util.ArrayList;

public class CardFileReader extends FileReader{
    private final String path = "cards.json";

    public CardFileReader() {
        super();
    }

    public ArrayList<Card> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Card> cards = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    public void writeLines(ArrayList<Card> cards){
        ArrayList<String> lines = new ArrayList<>();
        for (Card card : cards){
            lines.add(card.toString());
        }
        this.write(lines);
    }
}
