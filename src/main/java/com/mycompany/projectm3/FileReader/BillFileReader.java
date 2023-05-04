package com.mycompany.projectm3.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads and writes from the bills.csv file
 */
public class BillFileReader extends FileReader{
    private String path = "../DB/bills.csv";

    /**
     * Constructor
     */
    public BillFileReader() {
        super("bills.csv");
    }

    /**
     * Reads the lines from the file
     * @return ArrayList of lines from the file
     */
    public HashMap<Integer, Integer> readLines(){
        ArrayList<String> lines = this.read();
        System.out.println("Lines: " + lines);
        HashMap<Integer, Integer> bills = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) { // start loop at index 1 to skip header row
            System.out.println(lines.get(i));
            String[] fields = lines.get(i).split(",");
            int bill = Integer.parseInt(fields[0]);
            int amount = Integer.parseInt(fields[1]);
            System.out.println(bill + " " + amount);
            bills.put(bill, amount);
        }
        return bills;
    }

    /**
     * Writes the lines to the file
     * @param bills
     */
    public void writeLines(HashMap<Integer, Integer> bills){
        ArrayList<String> lines = new ArrayList<>();
        lines.add("bill,amount");
        for (Integer bill : bills.keySet()){
            lines.add(bill + "," + bills.get(bill));
        }
        System.out.println("Lines: " + lines);
        this.write(lines);
    }


}
