package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.Account.CurrentAccount;
import com.mycompany.projectm3.Account.SavingAccount;

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
            String[] fields = line.split(",");
            int account_id = Integer.parseInt(fields[0]);
            float balance = Float.parseFloat(fields[1]);
            int user_id = Integer.parseInt(fields[2]);
            long acc_num = Long.parseLong(fields[3]);
            String acc_type = fields[4];
            Account acc;
            if (acc_type.equals("Savings")){
                acc = new SavingAccount(account_id, balance, user_id, acc_num);
                System.out.println("Savings account created - User ID: " + user_id);
            } else {
                acc = new CurrentAccount(account_id, balance, user_id, acc_num);
                System.out.println("Account created - User ID: " + user_id);
            }
            accounts.add(acc);
        }
        System.out.println(accounts);
        return accounts;
    }

    /**
     * Writes the lines to the file
     *
     * @param accounts ArrayList of lines to write to the file
     */
    public void writeLines(ArrayList<Account> accounts){
        ArrayList<String> lines = new ArrayList<>();
        for (Account account : accounts){
            lines.add(account.toString());
        }
        this.write(lines);
    }

}
