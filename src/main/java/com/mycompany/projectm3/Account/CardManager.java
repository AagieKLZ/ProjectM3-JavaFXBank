package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.Account.Card;
import com.mycompany.projectm3.FileReader.CardFileReader;

import java.util.ArrayList;

public class CardManager {
    private ArrayList<Card> cardList;

    public CardManager(){
        this.cardList = new ArrayList<>();
    }
    public void assignCard(CurrentAccount account, int pin){
        Card card = new Card(pin, account);
        account.addCard(card);
    }

    public void saveCards(){
        CardFileReader cardFileReader = new CardFileReader();
        cardFileReader.writeLines(this.cardList);
    }
}
