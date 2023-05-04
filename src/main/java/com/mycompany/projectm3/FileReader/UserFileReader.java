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
        super("users.csv");
    }

    /**
     * Reads the lines from the file and returns an ArrayList of users
     * @return ArrayList of users from the file
     */
    public ArrayList<User> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<User> users = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
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
