package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

/**
 * Reads and writes from the users.json file
 */
public class UserFileReader extends FileReader {
    private final String path = "users.csv";

    /**
     * Constructor
     */
    public UserFileReader() {
        super("data/users.csv");
    }

    /**
     * Reads the lines from the file and returns an ArrayList of users
     * @return ArrayList of users from the file
     */
    public ArrayList<User> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++){
            String[] fields = lines.get(i).split(",");
            String name = fields[0];
            String email = fields[1];
            int id = Integer.parseInt(fields[2]);
            String password = fields[3];
            boolean locked = Boolean.parseBoolean(fields[4]);
            User user = new User(email, name, id);
            user.setPassword(password);
            user.setLocked(locked);
            users.add(user);
        }
        return users;
    }

    /**
     * Writes the lines to the file
     * @param users
     */
    public void writeLines(ArrayList<User> users){
        ArrayList<String> lines = new ArrayList<>();
        for (User user : users){
            lines.add(user.toString());
        }
        this.write(lines);
    }
}
