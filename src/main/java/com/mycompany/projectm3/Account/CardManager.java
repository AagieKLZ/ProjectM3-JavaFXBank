package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.Account.Card;
import com.mycompany.projectm3.FileReader.CardFileReader;

import java.util.ArrayList;

/**
 * @author Carlos Carpio
 * Class that manages the cards
 */
public class CardManager {
    private ArrayList<Card> cardList;

    /**
     * Constructor of the class
     */
    public CardManager(){
        this.cardList = new ArrayList<>();
        /*TODO - Add the filereader here*/
    }

    /**
     * Creates a card and assigns it to an account
     * @param account
     * @param pin
     */
    public void assignCard(CurrentAccount account, int pin){
        Card card = new Card(pin, account);
        account.addCard(card);
    }

    /**
     * Saves the cards to a file
     * @param card
     */
    public void saveCards(){
        CardFileReader cardFileReader = new CardFileReader();
        cardFileReader.writeLines(this.cardList);
    }
}
