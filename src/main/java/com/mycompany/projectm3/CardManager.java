package com.mycompany.projectm3;

public class CardManager {
    public void assignCard(CurrentAccount account, int pin){
        Card card = new Card(pin);
        account.addCard(card);
    }
}
