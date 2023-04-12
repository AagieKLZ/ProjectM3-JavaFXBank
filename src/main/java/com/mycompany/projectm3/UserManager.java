package com.mycompany.projectm3;

import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {
    private PasswordHasher hasher;
    private ArrayList<User> userList;
    private HashMap<Integer, Integer> attempts;
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
    public boolean LogIn(String name, String Password){ return false;}
    public void lockUser(User user){
        user.lock();
    }
    public void unlockUser(User user){
        user.unlock();
    }

}
