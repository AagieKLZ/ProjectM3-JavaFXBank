package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Account.Account;

import java.util.ArrayList;

public class AccountFileReader extends FileReader {
    private final String path = "accounts.json";

    public AccountFileReader() {
        super();
    }

    public ArrayList<Account> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Account> accounts = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    public void writeLines(ArrayList<Account> accounts){
        ArrayList<String> lines = new ArrayList<>();
        for (Account account : accounts){
            lines.add(account.toString());
        }
        this.write(lines);
    }

}
