package com.mycompany.projectm3.FileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class for reading and writing to files
 */
abstract class FileReader {
    protected String path = "";
    protected File file;

    /**
     * Creates a new FileReader object for a given file path and creates the file if it does not exist
     */
    public FileReader(String path) {
        this.file = new File(path);
    }

    /**
     * Reads the file and returns an ArrayList with each line as an element
     * @return each line of the file
     */
    public ArrayList<String> read(){
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error reading file");
        }
        return lines;
    }

    /**
     * Writes an ArrayList of lines to the file
     * @param lines
     */
    public void write(ArrayList<String> lines){
        ArrayList<String> currentLines = new ArrayList<>();
        for(String line : lines){
            currentLines.add(line);
        }
        try {
            Writer writer = new FileWriter(this.file);
            for (String line : currentLines){

                writer.write(line + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }
}