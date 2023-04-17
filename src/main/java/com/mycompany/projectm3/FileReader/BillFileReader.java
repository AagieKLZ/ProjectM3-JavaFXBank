package com.mycompany.projectm3.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class BillFileReader extends FileReader{
    private final String path = "bills.json";

    public BillFileReader() {
        super();
    }


    public HashMap<Integer, Integer> readLines(){
        ArrayList<String> lines = this.read();
        HashMap<Integer, Integer> bills = new HashMap<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    public void writeLines(HashMap<Integer, Integer> bills){
        ArrayList<String> lines = new ArrayList<>();
        for (Integer bill : bills.keySet()){
            lines.add(bill.toString());
        }
        this.write(lines);
    }


}
