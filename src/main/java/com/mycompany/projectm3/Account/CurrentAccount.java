package com.mycompany.projectm3.Account;
import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

/**
 * Represents a current account in the ATM
 */
public class CurrentAccount extends Account {
    private ArrayList<Card> cards;

    /**
     * Constructor for CurrentAccount
     * @param account_id
     * @param balance
     * @param owner
     */
    public CurrentAccount(int account_id, float balance, User owner){
        super(account_id, balance, owner);
        this.cards = new ArrayList<>();
    }

    /**
     * Constructor for CurrentAccount from file
     * @param account_id
     * @param balance
     * @param ownerId
     */
    public CurrentAccount(int account_id, float balance, int ownerId, long accNumber){
        super(account_id, balance, ownerId, accNumber);
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card to the account
     * @param card
     */
    public void addCard(Card card){
        this.cards.add(card);
    }

    /**
     * Deletes a card from the account
     * @param card
     */
    public void deleteCard(Card card){
        for (int i = 0; i <
        this.cards.size(); i++){
            if (this.cards.get(i).equals(card)){
                this.cards.remove(i);
                break;
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
