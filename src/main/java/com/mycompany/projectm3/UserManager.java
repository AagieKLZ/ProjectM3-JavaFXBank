package com.mycompany.projectm3;

import java.util.ArrayList;

public class UserManager {
    private PasswordHasher hasher;
    private ArrayList<User> userList;
    public void createUser(String name, String password){}
    public boolean userExists(String name){ return false;}
    public boolean LogIn(String name, String Password){ return false;}
    public void lockUser(User user){
        user.lock();
    }
    public void unlockUser(User user){
        user.unlock();
    }

}
