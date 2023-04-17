package com.mycompany.projectm3.User;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.FileReader.AccountFileReader;
import com.mycompany.projectm3.FileReader.UserFileReader;
import com.mycompany.projectm3.lib.PasswordHasher;

import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {
    private PasswordHasher hasher;
    private ArrayList<User> userList;
    private HashMap<Integer, Integer> attempts;

    public UserManager(){
        this.hasher = new PasswordHasher();
        this.userList = new UserFileReader().readLines();
        ArrayList<Account> accounts = new AccountFileReader().readLines();
        for (Account account : accounts){
            int userId = account.getOwnerId();
            for (User user : this.userList){
                if (user.getId() == userId){
                    user.openAccount(account);
                }
            }
        }
        this.attempts = new HashMap<>();
        for (User user: this.userList){
            this.attempts.put(user.getId(), 5);
        }
    }

    public void createUser(String name, String password){
        User user = new User(name, userList.size()+1);
        user.setPassword(password);
        this.userList.add(user);
    }
    public int findUser(String name){
        for (int i = 0; i < this.userList.size(); i++){
            if (name.equals(this.userList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
    public boolean LogIn(String name, String Password){
        /*TODO */
        return false;
    }
    public void lockUser(User user){
        user.lock();
    }
    public void unlockUser(User user){
        user.unlock();
    }

    public void saveUsers(){
        UserFileReader fileReader = new UserFileReader();
        fileReader.writeLines(this.userList);
    }

}
