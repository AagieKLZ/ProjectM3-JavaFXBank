package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

public class UserFileReader extends FileReader {
    private final String path = "users.json";

    public UserFileReader() {
        super();
    }

    public ArrayList<User> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<User> users = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    public void writeLines(ArrayList<User> users){
        ArrayList<String> lines = new ArrayList<>();
        for (User user : users){
            lines.add(user.toString());
        }
        this.write(lines);
    }
}
