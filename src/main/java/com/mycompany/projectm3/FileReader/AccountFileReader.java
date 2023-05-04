package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Account.Account;

import java.util.ArrayList;

/**
 * Reads and writes from the accounts.csv file
 */
public class AccountFileReader extends FileReader {
    private final String path = "accounts.csv";

    /**
     * Constructor
     */
    public AccountFileReader() {
        super("accounts.csv");
    }

    /**
     * Reads the lines from the file
     * @return ArrayList of lines from the file
     */
    public ArrayList<Account> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Account> accounts = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return accounts;
    }

    /**
     * Writes the lines to the file
     *
     * @param accounts ArrayList of lines to write to the file
     * @param generate
     */
    public void writeLines(ArrayList<Account> accounts, String generate){
        ArrayList<String> lines = new ArrayList<>();
        for (Account account : accounts){
            lines.add(account.toString());
        }
        this.write(lines);
    }

}
