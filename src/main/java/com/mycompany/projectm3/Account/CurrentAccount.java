package com.mycompany.projectm3.Account;
import com.mycompany.projectm3.Cards.Card;
import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

/**
 * Represents a current account in the ATM
 */
public class CurrentAccount extends Account {
    private ArrayList<Card> cards;

    /**
     * Constructor for CurrentAccount
     * @param account_id Account id
     * @param balance Balance of the account
     * @param owner Owner of the account
     */
    public CurrentAccount(int account_id, float balance, User owner){
        super(account_id, balance, owner);
        this.cards = new ArrayList<>();
        this.accType = "Current";
    }

    /**
     * Constructor for CurrentAccount from file
     * @param account_id Account id
     * @param balance Balance of the account
     * @param ownerId Owner id
     */
    public CurrentAccount(int account_id, float balance, int ownerId, long accNumber){
        super(account_id, balance, ownerId, accNumber);
        this.cards = new ArrayList<>();
        this.accType = "Current";
    }

    /**
     * Adds a card to the account
     * @param card Card to add
     */
    public void addCard(Card card){
        this.cards.add(card);
    }

    /**
     * Lists the cards of the account
     * @return List with the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
}
