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
        this.cardList = new CardFileReader().readLines();
    }


    /**
     * Saves the cards to a file
     */
    public void saveCards(){
        CardFileReader cardFileReader = new CardFileReader();
        cardFileReader.writeLines(this.cardList);
    }

    public Card createCard(int PIN, CurrentAccount account){
        Card card = new Card(PIN, account);
        return card;
    }

    public Card findCard(long cardNumber){
        for (Card card : this.cardList){
            if (card.getCardNumber() == cardNumber){
                return card;
            }
        }
        return null;
    }

    public void addCard(Card card){
        this.cardList.add(card);
    }

    public ArrayList<Card> getCards() {
        return cardList;
    }
}
