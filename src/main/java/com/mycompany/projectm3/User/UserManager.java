package com.mycompany.projectm3.User;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.FileReader.AccountFileReader;
import com.mycompany.projectm3.FileReader.UserFileReader;
import com.mycompany.projectm3.lib.PasswordHasher;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a user of the system.
 * @author Carlos Carpio
 */
public class UserManager {
    private PasswordHasher hasher;
    private ArrayList<User> userList;
    private HashMap<Integer, Integer> attempts;

    /**
     * Creates a new user manager and loads the users from the file.
     */
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

    /**
     * Creates a new user.
     * @param name
     * @param password
     */
    public void createUser(String email, String name, String password){
        User user = new User(email, name, userList.size()+1);
        user.setPassword(password);
        this.userList.add(user);
    }

    /**
     * Finds a user by its name
     * @param name
     * @return User if found, null otherwise
     */
    public int findUser(String name){
        for (int i = 0; i < this.userList.size(); i++){
            if (name.equals(this.userList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    /**
     * Tries to log in a user.
     * @param name
     * @param Password
     * @return true if the user is logged in, false otherwise
     */
    public boolean LogIn(String name, String Password){
        /*TODO */
        return false;
    }

    /**
     * Locks a user if the number of attempts is 0.
     * @param user
     */
    public void lockUser(User user){
        user.lock();
    }

    /**
     * Unlocks a user.
     * @param user
     */
    public void unlockUser(User user){
        user.unlock();
    }

    /**
     * Saves the users to the file.
     */
    public void saveUsers(){
        UserFileReader fileReader = new UserFileReader();
        fileReader.writeLines(this.userList);
    }

}
