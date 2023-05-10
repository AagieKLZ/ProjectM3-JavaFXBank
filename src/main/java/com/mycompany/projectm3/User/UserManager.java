package com.mycompany.projectm3.User;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.FileReader.AccountFileReader;
import com.mycompany.projectm3.FileReader.UserFileReader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a user of the system.
 * @author Carlos Carpio
 */
public class UserManager {
    private ArrayList<User> userList;
    private HashMap<String, Integer> attempts;

    /**
     * Creates a new user manager and loads the users from the file.
     */
    public UserManager(){
        this.userList = new UserFileReader().readLines();
        if (this.userList == null){
            this.userList = new ArrayList<>();
        }
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
            this.attempts.put(user.getEmail(), 5);
        }
    }

    /**
     * Creates a new user.
     * @param name
     * @param password
     */
    public User createUser(String email, String name, String password){
        User user = new User(email, name, userList.size());
        user.setPassword(password);
        this.userList.add(user);
        this.attempts.put(email, 5);
        saveUsers();
        return user;
    }

    /**
     * Finds a user by its name
     * @param email of the user
     * @return true if the user is found, false otherwise
     */
    public boolean findUser(String email){
        for (User user : this.userList) {
            if (email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tries to log in a user.
     * @param email
     * @param Password
     * @return true if the user is logged in, false otherwise
     */
    public User LogIn(String email, String Password){
        for (User user: userList){
            if (user.getEmail().equals(email)){
                if (user.getPassword().equals(Password)){
                    return user;
                }
            }
        }
        attempts.put(email, attempts.get(email) - 1);
        if (attempts.get(email) == 0){
            for (User user : userList){
                if (user.getEmail().equals(email)){
                    lockUser(user);
                }
            }
        }
        saveUsers();
        return null;
    }

    /**
     * Locks a user if the number of attempts is 0.
     * @param user
     */
    public void lockUser(User user){
        user.lock();
        saveUsers();
    }

    /**
     * Gets the number of attempts of a user.
     * @param email of the user
     * @return number of attempts
     */
    public int getAttempts(String email){
        return this.attempts.get(email);
    }

    /**
     * Saves the users to the file.
     */
    public void saveUsers(){
        UserFileReader fileReader = new UserFileReader();
        fileReader.writeLines(this.userList);
    }

    /**
     * Deletes a user.
     * @param user to be deleted
     */
    public void deleteUser(User user){
        this.userList.remove(user);
        saveUsers();
    }

}
