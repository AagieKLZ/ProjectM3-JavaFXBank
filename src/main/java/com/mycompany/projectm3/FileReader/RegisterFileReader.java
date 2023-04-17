package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Register.Register;

import java.util.ArrayList;

public class RegisterFileReader extends FileReader {
    private final String path = "registers.json";

    public RegisterFileReader() {
        super();
    }

    public ArrayList<Register> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Register> registers = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    public void writeLines(ArrayList<Register> registers){
        ArrayList<String> lines = new ArrayList<>();
        for (Register register : registers){
            lines.add(register.toString());
        }
        this.write(lines);
    }

}
