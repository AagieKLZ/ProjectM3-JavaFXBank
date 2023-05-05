package com.mycompany.projectm3.Cards;

import com.mycompany.projectm3.Account.CurrentAccount;
import com.mycompany.projectm3.Cards.Card;
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

    /**
     * Creates a card
     * @param PIN PIN of the card
     * @param account Account of the card
     * @return Card
     */
    public Card createCard(int PIN, CurrentAccount account){
        return new Card(PIN, account);
    }

    /**
     * Finds a card by its number
     * @param cardNumber Number of the card
     * @return Card if found, null if not
     */
    public Card findCard(long cardNumber){
        for (Card card : this.cardList){
            if (card.getCardNumber() == cardNumber){
                return card;
            }
        }
        return null;
    }

    /**
     * Adds a card to the list
     * @param card Card to add
     */
    public void addCard(Card card){
        this.cardList.add(card);
    }

    /**
     * Lists all the cards
     * @return ArrayList of cards
     */
    public ArrayList<Card> getCards() {
        return cardList;
    }
}
