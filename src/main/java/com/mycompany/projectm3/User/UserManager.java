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
    private ArrayList<User> userList;
    private HashMap<Integer, Integer> attempts;

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
            this.attempts.put(user.getId(), 5);
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
        saveUsers();
        return user;
    }

    /**
     * Finds a user by its name
     * @param email
     * @return User if found, null otherwise
     */
    public boolean findUser(String email){
        for (int i = 0; i < this.userList.size(); i++){
            if (email.equals(this.userList.get(i).getEmail())){
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
            System.out.println(user.getEmail() + " " + user.getPassword());
            if (user.getEmail().equals(email)){
                if (user.getPassword().equals(Password)){
                    return user;
                }
            }
        }
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
     * Unlocks a user.
     * @param user
     */
    public void unlockUser(User user){
        user.unlock();
        saveUsers();
    }

    /**
     * Saves the users to the file.
     */
    public void saveUsers(){
        UserFileReader fileReader = new UserFileReader();
        fileReader.writeLines(this.userList);
    }

}
