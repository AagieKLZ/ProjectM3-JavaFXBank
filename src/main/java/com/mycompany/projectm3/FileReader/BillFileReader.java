package com.mycompany.projectm3.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads and writes from the bills.csv file
 */
public class BillFileReader extends FileReader{
    private final String path = "bills.csv";

    /**
     * Constructor
     */
    public BillFileReader() {
        super();
    }

    /**
     * Reads the lines from the file
     * @return ArrayList of lines from the file
     */
    public HashMap<Integer, Integer> readLines(){
        ArrayList<String> lines = this.read();
        HashMap<Integer, Integer> bills = new HashMap<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    /**
     * Writes the lines to the file
     * @param bills
     */
    public void writeLines(HashMap<Integer, Integer> bills){
        ArrayList<String> lines = new ArrayList<>();
        for (Integer bill : bills.keySet()){
            lines.add(bill.toString());
        }
        this.write(lines);
    }


}
